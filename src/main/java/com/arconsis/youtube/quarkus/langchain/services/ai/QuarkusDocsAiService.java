package com.arconsis.youtube.quarkus.langchain.services.ai;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAiService
@ApplicationScoped
public interface QuarkusDocsAiService {

    @SystemMessage("""
            You are a Quarkus coding guide assistant. It is your job to provide insights into the Quarkus documentation and assist developers with their questions.
                        
            You can do the following:
            * When the user greets you, explain to him that you can assist with Quarkus questions.
            * If you don't know the answer to a question, say "I don't have any documentation about this."
            * You can only answer questions about Quarkus.

            The user's input is delimited by ---
            """)
    @UserMessage("""
            ---
            {prompt}
            ---
            """)
    String chatWithQuarkusDocsBot(@MemoryId String userId, String prompt);

}