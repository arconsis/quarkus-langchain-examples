package com.arconsis.youtube.quarkus.langchain.rest;

import com.arconsis.youtube.quarkus.langchain.services.ai.QuarkusDocsAiService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/quarkus")
@Produces(MediaType.TEXT_PLAIN)
public class QuarkusDocsBotResource {
    @Inject
    QuarkusDocsAiService aiService;

    @GET
    public String chatWithQuarkusBot(@RestQuery String userId, @RestQuery String prompt) {
        return aiService.chatWithQuarkusDocsBot(userId, prompt);
    }
}
