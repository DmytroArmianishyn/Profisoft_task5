package com.example.task5.service;

import com.example.task5.model.Mail;
import com.example.task5.mailSender.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MailErrorService {

    @Autowired
    private ElasticsearchOperations operations;

    @Autowired
    private MailSenderService service;


    @Scheduled(initialDelay = 10000L,fixedDelay =300000)
    public void checkMail(){
        Criteria criteria = new Criteria("status").is("Error");
        Query query = new CriteriaQuery(criteria);
        SearchHits<Mail> mails = operations.search(query, Mail.class);

        for (int i = 0; i < mails.getTotalHits() ; i++) {
            Mail tmp = mails.getSearchHit(i).getContent();
            service.send(tmp);
        }
    }
}
