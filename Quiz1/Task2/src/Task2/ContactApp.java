package Task2;

import java.util.Arrays;
import java.util.Comparator;

public class ContactApp {

	public static void main(String[] args) {
        // Sample contacts data
        Contact[] contacts = {
                new Contact("John", "Doe", "ABC Company", "Manager"),
                new Contact("Alice", "Smith", "XYZ Corporation", "Engineer"),
                new Contact("Bob", "Johnson", "123 Inc.", "Director")
        };

        // Convert contacts array to JSON format manually
        String jsonContacts = "[";

        for (int i = 0; i < contacts.length; i++) {
            jsonContacts += "{\"firstName\":\"" + contacts[i].getFirstName() + "\","
                    + "\"lastName\":\"" + contacts[i].getLastName() + "\","
                    + "\"company\":\"" + contacts[i].getCompany() + "\","
                    + "\"jobTitle\":\"" + contacts[i].getJobTitle() + "\"}";

            // Add comma if it's not the last element
            if (i < contacts.length - 1) {
                jsonContacts += ",";
            }
        }

        jsonContacts += "]";

        // Print JSON formatted contacts
        System.out.println(jsonContacts);
    
    }
}
