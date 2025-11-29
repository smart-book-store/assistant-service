package dev.cuong.smartbookstore.assistantservice.infrastructure;

import org.springframework.ai.chat.client.ChatClientCustomizer;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.UUID;

@Configuration
public class AssistantConfiguration {
  @Value("classpath:prompts/system-message.st")
  private Resource systemMessage;

  @Bean
  public ChatClientCustomizer chatClient(ChatMemory chatMemory) {
    return builder -> builder
        .defaultSystem(systemMessage)
        .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory)
            .conversationId(UUID.randomUUID().toString())
            .build());
  }

}