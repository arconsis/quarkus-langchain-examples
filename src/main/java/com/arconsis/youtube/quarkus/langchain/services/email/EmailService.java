package com.arconsis.youtube.quarkus.langchain.services.email;

import dev.langchain4j.agent.tool.Tool;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmailService {

    @Tool("sends an email to a single recipient's emailAddress with the given subject and content")
    public void sendEmailToRecipient(String emailAddress, String subject, String content) {
        Log.info(STR."Sending an email to: \{emailAddress} with subject \{subject} and content: \{content}");
    }
}
