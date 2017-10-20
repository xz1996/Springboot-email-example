package com.utility.email.service;

import com.utility.email.entity.Email;
import com.utility.email.entity.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSenderImpl mailSender;

    //change the sender configuration
    public void initSendService(Sender sender){
        String host = sender.getHost();
        String senderName = sender.getUsername();
        String senderPassword = sender.getPassword();

        if(host != null && senderName != null && senderPassword != null){
            mailSender.setHost(host);
            mailSender.setUsername(senderName);
            mailSender.setPassword(senderPassword);
        }
        else{
            System.out.println("init send service failed!");
        }
    }

    public void initSendService(String host, String senderName, String senderPassword){

       initSendService(new Sender(host, senderName, senderPassword));
    }


    public void sendSimpleMail(Email email){

        SimpleMailMessage message = new SimpleMailMessage();
        if(email.getSenderName() == null){
            message.setFrom(mailSender.getUsername());
        }
        else {
            message.setFrom(email.getSenderName());
        }
        message.setTo(email.getRecipientsName());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        try{
            mailSender.send(message);
            System.out.println("send successfully!");
        }catch(Exception e) {
            System.out.println("send failed!");
            e.printStackTrace();
        }
    }

    public void sendSimpleMail(String senderName, String recipientName, String subject, String text) {

        sendSimpleMail(new Email(senderName, recipientName, subject, text));

    }

    public void sendSimpleMail(String senderName, String[] recipientsName, String subject, String text) {

        sendSimpleMail(new Email(senderName, recipientsName, subject, text));

    }

    public void sendHtmlMail(Email email){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            if (email.getSenderName() == null) {
                mimeMessageHelper.setFrom(mailSender.getUsername());
            } else {
                mimeMessageHelper.setFrom(email.getSenderName());
            }

            mimeMessageHelper.setTo(email.getRecipientsName());
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setText(email.getText(), true);
            mailSender.send(mimeMessage);
            System.out.println("send successfully!");
        }catch (MessagingException e){
            System.out.println("send failed!");

        }
    }

    public void sendHtmlMail(String senderName, String recipientName, String subject, String text){

        sendHtmlMail(new Email(senderName, recipientName, subject, text));

    }

    public void sendHtmlMail(String senderName, String[] recipientsName, String subject, String text){

        sendHtmlMail(new Email(senderName, recipientsName, subject, text));

    }

    public void sendAttachmentsMail(Email email){

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            if(email.getSenderName() == null){
                mimeMessageHelper.setFrom(mailSender.getUsername());
            }
            else {
                mimeMessageHelper.setFrom(email.getSenderName());
            }

            mimeMessageHelper.setTo(email.getRecipientsName());
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setText(email.getText());

            File file = new File(email.getResourcePath());
            FileSystemResource resource = new FileSystemResource(file);
            mimeMessageHelper.addAttachment(file.getName(), resource);

            mailSender.send(mimeMessage);
            System.out.println("send successfully!");

        }catch (MessagingException e){
            System.out.println("send failed!");

        }

    }

    public void sendAttachmentsMail(String senderName, String recipientName, String subject, String text, String resourcePath){

        sendAttachmentsMail(new Email(senderName, recipientName, subject, text, resourcePath));

    }

    public void sendAttachmentsMail(String senderName, String[] recipientsName, String subject, String text, String resourcePath){

        sendAttachmentsMail(new Email(senderName, recipientsName, subject, text, resourcePath));

    }

}
