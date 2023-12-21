package com.arconsis.youtube.quarkus.langchain.services.ai;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterAiService
public interface MailAiService {

    @SystemMessage("""
            You are an email assistant AI.
            You help the user with creating the content and subject of an email.
                        
            You can do the following:
            * When the user greets you, explain to him what you can do and what he needs to provide.
            * If the user asks you to write a text for him, always reply with the text.
            * When the user provides you more data, enrich the email with that data an reply with the text.

            The user's input is delimited by ---
            """)
    @UserMessage("""
            ---
            {text}
            ---
            """)
    String chatWithMailBot(@MemoryId String memoryId, String text);
}
