package com.example.task5.mailSender;
import com.example.task5.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class MailSenderService {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Value("${spring.mail.username}")
    String owner;

    public void send(Mail mail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(owner);
        message.setTo(mail.getRecipient());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        try {
            mailSender.send(message);
            mail.setStatus("Done");
            System.out.println("EMail send success");
        }catch (Exception e){
            mail.setStatus("Error");
            mail.setErrorMessage(e.getMessage());
            System.out.println("Email was not sent");
        }
        mail.setLastAttemptTime(LocalDateTime.now().toString());
        int count = mail.getAttempts();
        System.out.println(count);
        mail.setAttempts(count+1);
        elasticsearchOperations.save(mail);
    }
}
