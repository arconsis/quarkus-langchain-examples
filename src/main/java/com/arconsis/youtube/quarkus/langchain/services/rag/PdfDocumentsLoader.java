package com.arconsis.youtube.quarkus.langchain.services.rag;

import dev.langchain4j.data.document.parser.PdfDocumentParser;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import io.quarkiverse.langchain4j.redis.RedisEmbeddingStore;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static dev.langchain4j.data.document.splitter.DocumentSplitters.recursive;

@ApplicationScoped
public class PdfDocumentsLoader {
    private final EmbeddingStoreIngestor ingestor;

    public PdfDocumentsLoader(RedisEmbeddingStore embeddingStore, EmbeddingModel embeddingModel) {
        ingestor = EmbeddingStoreIngestor.builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(embeddingModel)
                .documentSplitter(recursive(500, 0))
                .build();
    }

    public void onStart(@Observes StartupEvent startupEvent) throws IOException {
        ingestPdfsFromDirectory("C:/temp/2023-12_quarkus-llms-java/quarkus-langchain-docs");
    }

    void ingestPdfsFromDirectory(String directory) throws IOException {
        var parser = new PdfDocumentParser();

        Files.newDirectoryStream(Paths.get(directory), "*.pdf").forEach(pdf -> {
            try {
                var document = parser.parse(Files.newInputStream(pdf));
                ingestor.ingest(document);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
