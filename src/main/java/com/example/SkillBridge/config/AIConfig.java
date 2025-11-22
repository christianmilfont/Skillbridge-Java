package com.example.SkillBridge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.vertexai.chat.VertexAIChatModel;

@Configuration
public class AIConfig {

    @Bean
    public ChatModel chatModel() {
        // Substitua "gemini-2.0-flash" pelo modelo que você quer usar
        return VertexAIChatModel.builder()
                .modelId("gemini-2.0-flash")
                .build();
    }
}
