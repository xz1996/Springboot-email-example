package com.utility.email.entity;

public class Email {

    private String senderName;
    private String[] recipientsName;
    private String subject;
    private String text;
    private String resourcePath;

    public Email(){

    }

    public Email(String sender, String recipient){
        this.senderName = sender;
        this.recipientsName = new String[]{recipient};

    }

    public Email(String sender, String[] recipients){
        this.senderName = sender;
        this.recipientsName = recipients;

    }

    public Email(String sender, String recipient, String subject, String text){
        this.senderName = sender;
        this.recipientsName = new String[]{recipient};
        this.subject = subject;
        this.text = text;

    }

    public Email(String sender, String[] recipients, String subject, String text){
        this.senderName = sender;
        this.recipientsName = recipients;
        this.subject = subject;
        this.text = text;

    }

    public Email(String sender, String recipient, String subject, String text, String resourcePath){
        this.senderName = sender;
        this.recipientsName = new String[]{recipient};
        this.subject = subject;
        this.text = text;
        this.resourcePath = resourcePath;

    }

    public Email(String sender, String[] recipients, String subject, String text, String resourcePath){
        this.senderName = sender;
        this.recipientsName = recipients;
        this.subject = subject;
        this.text = text;
        this.resourcePath = resourcePath;

    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String sender) {
        this.senderName = sender;
    }

    public String[] getRecipientsName() {
        return recipientsName;
    }

    public void setRecipientsName(String[] recipient) {
        this.recipientsName = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }
}
