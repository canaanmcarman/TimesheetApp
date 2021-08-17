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

        final String username = "JavaMailTestMC@gmail.com";
        final String password = "helloworldpasswordtest";

        Session session = Session.getInstance(GetProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        return session;
    }

    public String BiuldTemplateWithContent(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        return templateEngine.process("mailtemplate", context);
    }

    public void SendSimpleEmail() {
        try {
            Message message = new MimeMessage(GetSession());
            message.setFrom(new InternetAddress("JavaMailTestMC@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("JavaMailTestMC@gmail.com"));
            message.setSubject("Hello World");
            message.setText("Hello Earth");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void SendTemplateedEmail(String message) {
        try {
            Message mimeMessage = new MimeMessage(GetSession());
            String content = BiuldTemplateWithContent(message);
            mimeMessage.setFrom(new InternetAddress("JavaMailTestMC@gmail.com"));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse("JavaMailTestMC@gmail.com"));
            mimeMessage.setSubject("Templeted text");
            mimeMessage.setContent(content, "text/html;charset=utf-8");
        } catch (MessagingException e) {
            throw new RuntimeException();
        }

    }

}
