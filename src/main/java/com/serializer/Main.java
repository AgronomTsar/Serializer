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
        String json="{\"firstName\":\"John\",\"lastName\":\"doe\",\"birthday\":\"10-авг-1970\"}";
        ObjectMapper n=new ObjectMapper();
        SimpleModule m1=new SimpleModule();
        m1.addDeserializer(Student.class,new StudentDeserializer());
        n.registerModule(m1);
        Student s1=n.readValue(json,Student.class);
        System.out.println(s1);


    }
}
