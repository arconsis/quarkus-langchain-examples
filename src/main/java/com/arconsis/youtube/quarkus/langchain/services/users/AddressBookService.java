package com.arconsis.youtube.quarkus.langchain.services.users;

import dev.langchain4j.agent.tool.Tool;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class AddressBookService {

    private final List<Contact> contacts = Arrays.asList(
            new Contact("Bernd", "Meier", "bernd.meier@arconsis.com", "arconsis"),
            new Contact("Hans", "Moleman", "hans.moleman@arconsis.com", "arconsis"),
            new Contact("Hans", "Moleman", "hans.moleman@molepeople.org", "Molepeople Org")
    );

    @Tool("Look up the email address and company for a person with the given first name and last name.")
    public List<Contact> getAddressForName(String firstName, String lastName) {
        Log.info(STR."Looking up contact in contact book \{firstName} \{lastName}");

        return contacts.stream()
                .filter(contact -> contact.firstName().equals(firstName) && contact.lastName().equals(lastName))
                .toList();
    }
}


