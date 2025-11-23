package com.example.SkillBridge.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
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

        var options = ChatOptionsBuilder.builder()
                .withTemperature(0.7)
                .build();

        return chatClient
                .prompt()
                .advisors(new SimpleLoggerAdvisor())
                .options(options)
                .user(prompt)
                .call()
                .content(); // ← O correto no M4
    }
}
