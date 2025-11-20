package com.example.SkillBridge.service;
import com.example.SkillBridge.dto.IoTResponseDTO;
import com.example.SkillBridge.dto.VagaCompatibilidadeDTO;
import com.example.SkillBridge.model.Compatibilidade;
import com.example.SkillBridge.model.Usuario;
import com.example.SkillBridge.model.Vaga;
import com.example.SkillBridge.repository.CompatibilidadeRepository;
import com.example.SkillBridge.repository.UsuarioRepository;
import com.example.SkillBridge.repository.VagaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service public class IoTService {

    private final UsuarioRepository usuarioRepository;
    private final VagaRepository vagaRepository;
    private final CompatibilidadeRepository compatibilidadeRepository;

    public IoTService(UsuarioRepository usuarioRepository,
                      VagaRepository vagaRepository,
                      CompatibilidadeRepository compatibilidadeRepository) {
        this.usuarioRepository = usuarioRepository;
        this.vagaRepository = vagaRepository;
        this.compatibilidadeRepository = compatibilidadeRepository;
    }

    public void processarDadosDoIoT(IoTResponseDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + dto.getId()));

        // Remove compatibilidades antigas
        compatibilidadeRepository.deleteByUsuarioId(usuario.getId());

        // Salva todas as compatibilidades
         for (VagaCompatibilidadeDTO v : dto.getTodas_as_vagas()) {

        Vaga vaga = vagaRepository.findById(v.getVaga_id()).orElse(null);

        if (vaga == null) {
            System.out.println("Vaga inexistente no MySQL: " + v.getVaga_id());
            continue;
        }

        Compatibilidade comp = new Compatibilidade();
        comp.setUsuario(usuario);
        comp.setVaga(vaga);
        comp.setPorcentagem(v.getCompatibilidade());
        comp.setMelhor(false);
        comp.setGeradoEm(LocalDateTime.now());

        compatibilidadeRepository.save(comp);
    }

    // Marca a melhor vaga
    compatibilidadeRepository.findByUsuarioIdAndVagaId(
                dto.getId(),
                        dto.getMelhor_vaga().getVaga_id()
        ).ifPresent(c -> {
        c.setMelhor(true);
        compatibilidadeRepository.save(c);
    });
}
}