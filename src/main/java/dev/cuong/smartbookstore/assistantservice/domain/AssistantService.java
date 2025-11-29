package dev.cuong.smartbookstore.assistantservice.domain;

import dev.cuong.smartbookstore.assistantservice.web.ChatRequest;
import dev.cuong.smartbookstore.assistantservice.web.ChatResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Application service to orchestrate the chat use case.
 * It uses the domain interface (ChatAssistant) to perform the business logic.
 *
 * @author Cuong Tran
 */
@Service
public class AssistantService {
  private static final Logger LOGGER = LoggerFactory.getLogger(AssistantService.class);
  private final AiService chatAssistant;

  public AssistantService(AiService chatAssistant) {
    this.chatAssistant = chatAssistant;
  }

  public ChatResponse chat(ChatRequest request) {
    LOGGER.info("Sending message to assistant: {}", request.message());
    String content = chatAssistant.chat(request.message());
    return new ChatResponse(content);
  }
}