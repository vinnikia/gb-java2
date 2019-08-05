package lesson3;

import java.util.*;

public class Phonebook {

    int id = 0;
    Map<Integer, ArrayList<String>> contacts;

    public Phonebook() {
        contacts = new HashMap<>();
    }

    public void add(String name, String phone) {
       id++;
       ArrayList<String> contact = new ArrayList<>(2);
       contact.add(name);
       contact.add(phone);
       contacts.put(id, contact);
    }

    public ArrayList get(String name) {

        ArrayList<String> phones = new ArrayList<>();
        ArrayList<String> contact;
        for(int i = 1; i <= id; i++) {
            contact = contacts.get(i);
            if(contact.get(0).equals(name)){
                phones.add(contact.get(1));
            }

        }

        System.out.println(phones);
        return phones;

    }
}
