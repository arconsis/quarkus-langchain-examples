package com.arconsis.youtube.quarkus.langchain.rest;

import com.arconsis.youtube.quarkus.langchain.services.ai.SimplePoemAiService;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/poem")
@Produces(MediaType.TEXT_PLAIN)
public class PoemResource {
    
    @Inject
    SimplePoemAiService simplePoemAiService;

    @GET
    public String writeSimplePoem(@RestQuery String topic, @RestQuery @DefaultValue("4") int lines) {
        return simplePoemAiService.writePoem(topic, lines);
    }
}
