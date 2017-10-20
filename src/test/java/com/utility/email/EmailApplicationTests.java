package com.utility.email;

import com.utility.email.entity.Email;
import com.utility.email.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("163")
public class EmailApplicationTests {

	@Autowired
	private EmailService emailService;


	@Test
	public void contextLoads() {
	}

	@Test
	public void httpClientTest(){

	}

	@Test
	public void sendSimpleMail() throws Exception{

		emailService.sendSimpleMail("xz11303010139@163.com", "632861725@qq.com", "email test","this is a test email!");
	}


	@Test
	public void sendHtmlMail() throws Exception{
		String[] rec = new String[]{"632861725@qq.com", "xz11303010139@yeah.net"};
		StringBuffer text = new StringBuffer();
		text.append("<h1>h1</h1>")
				.append("<p style='color:#F00'>Red color</p>")
				.append("<p style='text-align:right'>right alignment</p>");
		Email email = new Email("xz11303010139@163.com", rec, "email test", text.toString());
		emailService.sendHtmlMail(email);
	}

	@Test
	public void sendMimeMail()throws Exception{

		Email email = new Email("xz11303010139@163.com", "632861725@qq.com",
				"email test","this is a test email!","C:\\Users\\x1twbm\\Desktop\\New Text Document (2).txt");
		emailService.sendAttachmentsMail(email);
	}

}
