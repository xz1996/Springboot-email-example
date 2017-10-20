package com.utility.email.controller;

import com.utility.email.service.EmailService;
import com.utility.email.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public ResponseEntity index(){
        try {

            emailService.sendSimpleMail("xz11303010139@163.com", "632861725@qq.com", "email test","this is a test email!");
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity("send email ok", HttpStatus.OK);
    }
}
