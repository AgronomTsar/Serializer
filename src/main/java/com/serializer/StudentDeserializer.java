package com.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentDeserializer extends StdDeserializer<Student> {
    protected StudentDeserializer() {
        super(Student.class);
    }
    @Override
    public Student deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode root=parser.getCodec().readTree(parser);
        JsonNode fnameNode=root.get("firstName");
        String firstName=fnameNode.asText();
        String lastName=root.get("lastName").asText();
        String birthday=root.get("birthday").asText();
        DateTimeFormatter f=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate bday=LocalDate.parse(birthday,f);
        return new Student(firstName,lastName,bday);

    }
}
