package com.lesson02.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson02.models.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONReader {
    /**
     * Reads Person objects from a JSON file. I Use Jackson reader =)
     *
     * Expected JSON format:
     * name,age,email
     * John Doe,30,john@example.com
     * Jane Smith,25,jane@example.com
     *
     * @param filePath Path to the CSV file
     * @return List of Person objects
     * @throws IOException if file cannot be read
     */
    public static List<Person> readPersonsFromJSON(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(
                new File(filePath),
                new TypeReference<List<Person>>() {}
        );
    }
}

