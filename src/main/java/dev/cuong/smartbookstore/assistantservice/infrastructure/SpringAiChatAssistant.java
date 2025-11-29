package dev.cuong.smartbookstore.assistantservice.infrastructure;

import dev.cuong.smartbookstore.assistantservice.domain.AiService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * Infrastructure-specific implementation of the ChatAssistant domain interface.
 * This class uses the Spring AI ChatClient to communicate with an LLM.
 *
 * @author cuongtran1984
 */
@Component
public class SpringAiChatAssistant implements AiService {
  private final ChatClient chatClient;

  public SpringAiChatAssistant(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  @Override
  public String chat(String message) {
    return chatClient.prompt()
        .user(message)
        .call()
        .content();
  }

  @Override
  public Flux<String> stream(String message) {
    return chatClient.prompt()
        .user(message)
        .stream()
        .content();
  }
}