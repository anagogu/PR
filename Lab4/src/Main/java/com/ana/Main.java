package com.ana;

import org.apache.commons.mail.*;
import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        System.out.println("Menu");
        System.out.println("1. Send the message");
        System.out.println("2. Send a message with attachment");
        System.out.println("3. Send a mesage with HTML");
        System.out.println("4. Read the message");
        System.out.println("5. Quit");

        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {

            case 1:

                System.out.println("Client simplu de posta – trimitere mesaj");
                try {

                    Email email = new SimpleEmail();
                    email.setHostName("127.0.0.1");
                    email.setSmtpPort(25);
                    email.setFrom("ana@ana.gogu");
                    email.setSubject("Mesage at me for me");
                    email.setMsg("First simple message !");
                    email.addTo("ana@ana.gogu");
                    email.send();

                } catch (EmailException e) {
                    e.printStackTrace();
                }

                break;
            case 2:
                System.out.println("Client simplu de posta – trimitere mesaj cu atașament");
                try {
                    EmailAttachment attachment = new EmailAttachment();
                    attachment.setPath("G:\\Ana\\Unversitate\\ilustration\\2.png");
                    attachment.setDisposition(EmailAttachment.ATTACHMENT);
                    attachment.setDescription("Picture realise of Ana");
                    attachment.setName("Supa");

                    // Create the email message
                    MultiPartEmail email = new MultiPartEmail();
                    email.setHostName("127.0.0.1");
                    email.setFrom("ana@ana.gogu");
                    email.setSubject("The picture");
                    email.setMsg("Here is the picture you wanted");
                    email.addTo("ana@ana.gogu");


                    // add the attachment
                    email.attach(attachment);

                    // send the email
                    email.send();
                } catch (EmailException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                // Recipient's email ID needs to be mentioned.
                String to = "ana@ana.gogu";

                // Sender's email ID needs to be mentioned
                String from = "ana@ana.gogu";
                final String username = "ana";
                final String password = "root";

                String host ="127.0.0.1";

                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "25");
                // Get the Session object.
                Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        });
                try {

                    MimeMessage message;
                    message = new MimeMessage(session);

                    // Set From: header field of the header.
                    message.setFrom(new InternetAddress(from));

                    // Set To: header field of the header.
                    message.setRecipients(MimeMessage.RecipientType.TO,
                            InternetAddress.parse(to));

                    // Set Subject: header field
                    message.setSubject("Testing Subject");

                    // Send the actual HTML message, as big as you like
                    message.setContent(
                            "<h1>This is actual message embedded in HTML tags</h1>"+"<img src=\"http://www.rgagnon.com/images/jht.gif\">",
                            "text/html");
                   // DataSource fds = new FileDataSource(
                   //         "C:/Users/Root/PRproiects/Lab4/images/supa.png");

                   // message.setDataHandler(new DataHandler(fds));
                  //  message.setHeader("Content-ID", "<image>");
                    // Send message
                    Transport.send(message);

                    System.out.println("Sent message successfully....");

                } catch (MessagingException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                break;


            case 4:
                System.out.println("Client simplu de posta – citire mesaj");
                try {

                    POP3Client client = new POP3Client();
                    client.connect( "127.0.0.1", 110 );
                    if( client.login( "ana", "root" ) )

                    {

                        POP3MessageInfo[] messages = client.listMessages();
                        System.out.println( "Mesaje: " + messages.length );
                        System.out.println( "Textul mesajului");
                        Reader r = client.retrieveMessage( messages[ 2 ].number );
                        BufferedReader br = new BufferedReader( r );
                        String line;
                        while( ( line = br.readLine()) != null )
                        {
                            System.out.println(line);
                        }
                    }
                    else
                    {
                        System.out.println( "Logare fara succes..." );
                    }
                    client.logout();
                    client.disconnect();
                } catch (IOException ignored){ }
                break;

            case 5:
                break;

            default:
                System.out.println("Default choice");
                break;
        }
    }
}
