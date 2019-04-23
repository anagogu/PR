# Programare in Retea</br>
### Laboratorul 4</br>
*Scopul lucrarii:*</br>
  Crearea unui client simpu de posta electronica apt sa trimita si sa citesca mesaje
prin intermediul unui cont de posta electronica.
Sarcini:</br>
a) Trimiterea unei scrisori cu atasamente;</br.
b) Trimiterea unei scrisori formatate HTML, incluzind imagine;</br>
c) Elaborarea unei clase POP3Header care ar facilita citirea din mesajul citit al 
antetelor.</br>

*Desfasurarea lucrarii:*</br>
Modelul client server
Serverul este o aplicatie care ofera servicii clientilor sositi prin retea. Serverele ofera o gama variata de servicii.  Serverul cel mai cunoscut este serverul Web, care furnizeaza documentele cerute de catre clienti. Un alt serviciu cunoscut este posta electronica, care utilizeaza protocoalele SMPT (Simple Mail Transfer Protocol) si IMAP4 (Internet Mail Access Protocol). Pe principiul client-server funnctioneaza si protocoalele NFS (Network File Service) si  FTP sau serviciul de nume de domenii  DNS (Domain Name Service) si serviciul de informatii despre retea NIS (Network Information Services). Trebuie sa amintim si serviciul care permite logarea la un calculator aflat la distanta: TELNET si RLOGIN. Putem trage concluzia ca arhitectura client-server este instrumentul de baza in dezvoltarea aplicatiilor de retea.
Clientul  este o aplicatie care utilizeaza serviciile oferite de catre un server. Pentru a putea realiza acest lucru, clientul trebuie sa cunoasca unde se afla serverul in retea si cum trebuie comunicat cu acesta si ce servicii ofera. Deci daca un client doreste o comunicare cu serverul, trebuie sa cunosca trei lucruri:
adresa server
portul server utilizat pentru comunicare
protocolul de comunicatie utilizat de server
Daca aceste date ne stau la dispozitie, putem realiza comunicatia cu serverul.

JavaMail este un API Java folosit pentru a trimite si a primi e-mail prin SMTP, POP3 si IMAP. JavaMail este integrat in platforma Java EE, dar ofera si un pachet optional pentru utilizarea in Java SE.

Pentru efectuarea acestei lucrari de laborator am folosit programa propusa de catre profesor "Quick'n Easy Mail Server" acesta fiind perfect 
pentru cei ce doresc sa ruleze propriul lor mini mail server, acesta este si cazul nostru. Aceasta programa e ofera pe deplin tot ce este necesar
pentru efectuarea lucrarii cum ar fi </br>
- Serverul POP3.</br>
- Server SMTP.</br>
- Autentificare POP3 și SMTP.</br>
### COdul sursa al programului
#### Main.java
```
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
```
Pentru navigarea mai simpla si placuta prin punctele ce reprezinta laboratorul dat am creat un meniu
simplu care ne permite sa alegem punctul necesar.
```
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
```
Rezultatul rularii programului si fiecare obtiune a meniului creat precum si datele generate in interiorul programei "Quick'n Easy Mail Server"
pot fi urmarite mai jos:</br>
Deci Meniul propri-zis:</br>
![Fig9](images/Fig9.png)</br>

Mail-urile au fost generate intr-o mapa "Mailboxes" care contine mai multe foldere cu numele utilizatorilor creati, in interiorul carora se contin 
mail-urile</br>
![Fig2](images/Fig2.png)</br>

Careva date generate in "Quick'n Easy Mail Server" in urma actiunilor mele sunt prezentate mai jos:</br>
![Fig1](images/Fig1.png)</br>
![Fig6](images/Fig6.png)</br>
![Fig7](images/Fig7.png)</br>

Deci, la punctul 1 al meniului avem posibilitatea de a trimite un mesaj simplu. Aceasta parte am efectuato cel mai usor utilizind metodele (functiile)
oferite de bibliotecile importate. Iata si rezultatul:
![Fig10](images/Fig10.png)</br>

La punctul 2 deja sa complicat putin sarcina, am invatat cum se poate trimite prin cod un mail cu atasament. Lafel destul de accesibila realiazarea, am 
mai folosit metode precum attach, setPath care il cunoastem din laboratoarele precedente.
![Fig4](images/Fig4.png)</br>

Iata la punctul 3 am intilnit deja mai multe dificultati, si anume la inserarea imaginii in mailprin tag-uri html. Nu oricare imagine se afisa. Si insasi
sarcina data a necesitat mai mult timp si informare suplimentare 
![Fig5](images/Fig5.png)</br>

Punctul 4 afiseaza ceea ce programul creat a citit din header, (daca ma pot exprima asa). In total, eu am avut 3 mesaje. Secventa de cod de la case-ul 4
se logheaza si prin protocolul POP3 primeste acces la lista mea de mesaje si pentru a vedea, am pus sa o afiseze in consola.
![Fig8](images/Fig8.png)</br>
