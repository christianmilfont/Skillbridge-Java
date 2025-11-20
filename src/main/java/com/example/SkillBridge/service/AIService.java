package com.example.SkillBridge.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final ChatModel chatModel;

    public AIService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String gerarDescricaoMelhorVaga(String vagaTitulo, int compatibilidade) {

        String promptText = """
                Explique de forma amigável por que esta vaga é adequada ao usuário.
                Vaga: %s
                Compatibilidade: %d%%
                Responda em no máximo 6 linhas.
                """.formatted(vagaTitulo, compatibilidade);

        Prompt prompt = new Prompt(promptText);

        ChatResponse response = chatModel.call(prompt);

        return response
                .getResult()
                .getOutput()
                .getText();
    }
}
