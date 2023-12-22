package com.arconsis.youtube.quarkus.langchain.services.rag;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import dev.langchain4j.retriever.Retriever;
import io.quarkiverse.langchain4j.redis.RedisEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class DocumentsRetriever implements Retriever<TextSegment> {
    private EmbeddingStoreRetriever retriever;

    public DocumentsRetriever(RedisEmbeddingStore embeddingStore, EmbeddingModel embeddingModel) {
        retriever = EmbeddingStoreRetriever.from(embeddingStore, embeddingModel, 20);
    }

    @Override
    public List<TextSegment> findRelevant(String text) {
        return retriever.findRelevant(text);
    }
}
