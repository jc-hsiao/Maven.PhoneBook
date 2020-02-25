package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    Map<String,List<String>> map = new LinkedHashMap<>();

    public PhoneBook(Map<String, List<String>> map) {
        for (String name :map.keySet()) {
            this.map.put(name,map.get(name));
        }
    }

    public PhoneBook() { }

    public void add(String name, String phoneNumber) {
        if(map.containsKey(name)){
            map.get(name).add(phoneNumber);
        }else
            this.map.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        this.map.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        this.map.remove(name);
    }

    public Boolean hasEntry(String phoneNumber) {
        return reverseLookup(phoneNumber) != null;
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String name :map.keySet()) {
            if(map.get(name).contains(phoneNumber)){
                return name;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(map.keySet());
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
