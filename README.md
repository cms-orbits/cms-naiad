# CMS Naiad
[![Build Status](https://travis-ci.org/joelgtsantos/cms-naiad.svg?branch=master)](https://travis-ci.org/joelgtsantos/cms-naiad)


This application is an Email Service that consumes requests from a RabbitMQ server and sends mails according with the properties in each message, this properties must be in JSON Format.


### Configuration file

Inside of the configuration file there are some properties that need to be set in order to run the application

- Gmail account
- RabbitMQ connection


#### Gmail account

The Gmail account has two parameters, the email direction and password

```yml
---
spring:
  #Email
  mail:
    host: smtp.gmail.com
    username: some@gmail.com
    password: somepassword
```


#### RabbitMQ connection

This connection will provide the queue of messages so that the application read and will send them to the recipients..

```yml
---
spring:
  rabbitmq:
    host: 192.168.187.133
    port: 5672
    username: rabbit
    password: rabbit1
```

### Local Run Instructions

1) mvn install
2) mvn spring-boot:run


 
### Email testing

The application can be tested sending a new message to the RabbitMQ Server using a terminal

```bash
$ rabbitmqadmin publish exchange=cmsExchange routing_key=user.created \
    properties='{"content_type":"application/json"}' \
    payload='{"name": "CMS USER", \
    "to":"someotheremail@gmail.com", \ 
    "from":"cms@gmail.com", \
    "body":"Welcome to CMS Challenge", \
    "subject":"Signing up CMS"}'
    
```

### Running a docker image 

The application runs by default on port 8084 but such value can be overridden using the following syntax.

```bash
$ docker run -t -i -e SERVER_PORT='8084' joelgtsantos/cms-naiad:latest

```




 
 
