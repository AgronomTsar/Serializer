package com.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Student s=new Student("John","doe", LocalDate.of(1899,10,10));
        ObjectMapper om=new ObjectMapper();
        SimpleModule m=new SimpleModule();
        m.addSerializer(Student.class,new StudentSerializer());
        om.registerModule(m);
        System.out.println(om.writeValueAsString(s));

    }
}
