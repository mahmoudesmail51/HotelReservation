/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhotel;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailSender {
  public static void send (String to,String body,String subject)
      throws Exception {
    Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
          
       String from = "friendshotel.99@gmail.com";
       String password = "HotelFriends99";

         Session session = Session.getDefaultInstance(props, 
                                    new javax.mail.Authenticator()
                                {
                                    protected PasswordAuthentication getPasswordAuthentication() 
                                    {
                                return new PasswordAuthentication(from, password);// Specify the Username and the PassWord
                                    }
                                });
          MimeMessage msg = new MimeMessage(session);
          //set message headers
          msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
          msg.addHeader("format", "flowed");
          msg.addHeader("Content-Transfer-Encoding", "8bit");

          msg.setFrom(new InternetAddress(from,"ADMIN"));

          msg.setReplyTo(InternetAddress.parse(from, false));

          msg.setSubject(subject, "UTF-8");

          msg.setText(body , "UTF-8");

          msg.setSentDate(new Date());

          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
              Transport trans=session.getTransport("smtp");
              trans.connect("smtp.gmail.com",from,password);
              trans.sendMessage(msg,msg.getAllRecipients());

        }
       
    }  


