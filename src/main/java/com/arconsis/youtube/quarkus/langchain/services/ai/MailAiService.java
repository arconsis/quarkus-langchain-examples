package com.arconsis.youtube.quarkus.langchain.services.ai;

import com.arconsis.youtube.quarkus.langchain.services.email.EmailService;
import com.arconsis.youtube.quarkus.langchain.services.users.AddressBookService;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterAiService(tools = {EmailService.class, AddressBookService.class})
public interface MailAiService {

    @SystemMessage("""
            You are an email assistant AI. You guide the user through the process of sending an email.
            You gather all information required to send an email for the user.
            You also help the user with creating the content or subject if he asks for it.

            You can do the following:
            * when the user greets you, explain to him what you can do and what he needs to provide.
            * if you know the recipients first name and last name, look up the email address immediately and show it to the user.
            * if the users says something like "I want to send an email to xxx yyy", then xxx is considered the first name and yyy is considered the last name.
            * when the user gave you some data, show this data to the user again to make sure it is correct.
            * if you don't know an information, answer that you don't know.
            * if the user has not provided the recipients email address, the mail subject or the mail content, ask the user to provide it.
            * if you are asked to send an email to multiple recipients, send each recipient and individual mail.
            """)
    String chatWithMailBot(@MemoryId String memoryId, @UserMessage String prompt);
}
