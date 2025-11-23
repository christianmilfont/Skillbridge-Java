package com.example.SkillBridge.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final ChatClient chatClient;

    public AIService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String gerarDescricaoMelhorVaga(String vagaTitulo, int compatibilidade) {

        String prompt = """
                Explique de forma amigável por que esta vaga é adequada ao usuário.
                Vaga: %s
                Compatibilidade: %d%%
                Responda em no máximo 6 linhas.
                """.formatted(vagaTitulo, compatibilidade);

        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .content(); // <- já retorna o texto direto
    }
}
