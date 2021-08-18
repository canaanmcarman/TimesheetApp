package com.example.springboot_security403;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    private TemplateEngine templateEngine;
    @Autowired
    Environment env;

    @Autowired
    public EmailService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    private Properties GetProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable",env.getProperty("mail.smtp.starttls.enable"));
        props.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
        props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
        props.put("mail.smtp.port", env.getProperty("mail.smtp.port"));

        return props;
    }

    private Session GetSession() {

        final String username = "ccamaru89@gmail.com";
        final String password = "89ccamaru";

        Session session = Session.getInstance(GetProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password); }});

        return session;
    }

    public String BuildTemplateWithContent(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        return templateEngine.process("mailtemplate", context);
    }

    public void SendSimpleEmail(String text, String subject) {
        try {
            Message message = new MimeMessage(GetSession());
            message.setFrom(new InternetAddress("ccamaru89@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ccamaru89@gmail.com"));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void SendTemplatedEmail(String message) {
        try {
            Message mimeMessage = new MimeMessage(GetSession());
            String content = BuildTemplateWithContent(message);
            mimeMessage.setFrom(new InternetAddress("ccamaru89@gmail.com"));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ccamaru89@gmail.com"));
            mimeMessage.setSubject("Templated text");
            mimeMessage.setContent(content, "text/html;charset=utf-8");
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException();
        }

    }

}
