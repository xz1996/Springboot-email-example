package com.utility.email.service;

import com.utility.email.entity.Email;
import com.utility.email.entity.Sender;

public interface EmailService {

    public void initSendService(Sender sender);
    public void initSendService(String host, String senderName, String senderPassword);

    public void sendSimpleMail(Email email);
    public void sendSimpleMail(String senderName, String recipientName, String subject, String text);
    public void sendSimpleMail(String senderName, String[] recipientsName, String subject, String text);

    public void sendHtmlMail(Email email);
    public void sendHtmlMail(String senderName, String recipientName, String subject, String text);
    public void sendHtmlMail(String senderName, String[] recipientsName, String subject, String text);

    public void sendAttachmentsMail(Email email);
    public void sendAttachmentsMail(String senderName, String recipientName, String subject, String text, String resourcePath);
    public void sendAttachmentsMail(String senderName, String[] recipientsName, String subject, String text, String resourcePath);

}
