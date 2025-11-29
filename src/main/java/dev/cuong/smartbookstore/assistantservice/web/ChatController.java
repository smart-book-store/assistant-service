package dev.cuong.smartbookstore.assistantservice.web;

import dev.cuong.smartbookstore.assistantservice.domain.AssistantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1")
public class ChatController {
  private final AssistantService assistantService;

  public ChatController(AssistantService assistantService) {
    this.assistantService = assistantService;
  }

  @PostMapping("/chat")
  public ChatResponse chat(@RequestBody ChatRequest request) {
    return assistantService.chat(request);
  }

  @PostMapping("/stream-chat")
  public Flux<ChatResponse> stream(Flux<ChatRequest> request) {
    return null;
  }
}
