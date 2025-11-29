package dev.cuong.smartbookstore.assistantservice.domain;

import reactor.core.publisher.Flux;

/**
 * Represents the core domain capability of an AI service.
 * <p>
 * This interface is part of the domain layer and is independent of any specific implementation or framework.
 *
 * @author Cuong Tran
 */
public interface AiService {
  String chat(String message);

  default Flux<String> stream(String message) {
    return Flux.empty();
  }
}