package com.arconsis.youtube.quarkus.langchain.services.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface SimplePoemAiService {

    @SystemMessage("You are a professional poet.")
    @UserMessage("""
            Write a poem about {topic}. The poem should be {lines} lines long.
            """)
    String writePoem(String topic, int lines);
}
