package com.example.task5.consumer;

import com.example.task5.model.Mail;
import com.example.task5.mailSender.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    MailSenderService service;
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Value("${spring.mail.admin}")
    String adminMail;


    @KafkaListener(topics = "topic-email", groupId = "email-group")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
        Mail mail =new Mail();
        mail.createEmail("Information",message,adminMail);
        Criteria criteria = new Criteria("id");
        Query query = new CriteriaQuery(criteria);
        mail.setId((int) elasticsearchOperations.count(query, Mail.class));
       service.send(mail);
    }
}