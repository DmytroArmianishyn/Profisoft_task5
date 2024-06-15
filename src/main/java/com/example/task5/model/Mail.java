package com.example.task5.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName="students")
public class Mail {


    @Id
    private int id;
    @Field(type = FieldType.Text)
    private String subject;
    @Field(type = FieldType.Text)
    private String content;
    @Field(type = FieldType.Keyword)
    private String recipient;
    @Field(type = FieldType.Keyword)
    private String status;
    @Field(type = FieldType.Text)
    private String errorMessage;
    @Field(type = FieldType.Integer)
    private int attempts;
    @Field(type = FieldType.Date)
    private String lastAttemptTime;


    public void createEmail(String subject,String content,String recipient){
        this.subject=subject;
        this.content=content;
        this.recipient=recipient;
        this.status="waiting";
        this.errorMessage=null;
        this.attempts=0;
        this.lastAttemptTime= null;
    }
}
