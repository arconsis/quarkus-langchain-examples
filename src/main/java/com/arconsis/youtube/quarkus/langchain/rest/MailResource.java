package com.arconsis.youtube.quarkus.langchain.rest;

import com.arconsis.youtube.quarkus.langchain.services.ai.MailAiService;
import io.quarkiverse.langchain4j.ChatMemoryRemover;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/mails")
@Produces(MediaType.TEXT_PLAIN)
public class MailResource {
    @Inject
    MailAiService aiService;

    @GET
    public String sendAnEmail(@RestQuery String userId, @RestQuery String query) {
        return aiService.chatWithMailBot(userId, query);
    }
}
