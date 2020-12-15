package com.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentSerializer extends StdSerializer<Student> {

    protected StudentSerializer() {
        super(Student.class);
    }

    public void serialize(Student s, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("first_Name",s.getFirstName());
        gen.writeStringField("last_Name",s.getLastName());
        DateTimeFormatter f=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        gen.writeStringField("birthday",s.getBirthday().format(f));
        gen.writeEndObject();
    }
}
