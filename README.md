# Email  Service

This project provides an email dispatch service implemented as a microservice using Java, Spring Boot, Kafka, and Elasticsearch. The service receives email details asynchronously through a message broker, stores them in a database, and attempts to send them via an SMTP server. If the email server is unavailable, the service retries sending the emails periodically.

* For the application to start, you need to go into the properties
and insert your data into spring.mail.username,spring.mail.admin
,spring.mail.password. spring.mail.admin is the
admin email to which notifications will be sent.

* We receive notifications from the ProfiTsoft_Task2 microservice
. Depending on the user's actions, notifications are sent to
our microservice about adding, deleting, changing or viewing 
player data.
* this is the message we receive from the microservice that
we will send to the administrator.

## Features
1. Asynchronous email receiving via Kafka.
2. Storage of email details in Elasticsearch.
3. Sending emails via SMTP using Spring's JavaMailSender.
4. Retry mechanism for failed email sends.
5. Integration tests for email sending logic.
6. Dockerized setup with Docker Compose for easy deployment.


## Technologies Used
1. Java
2. Spring Boot
3. Kafka
4. Elasticsearch
5. Docker
6. Docker Compose


Contributors
[Dmytro Armianishyn]
