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
### COdul sursa al programului
#### Main.java
```
package com.ana;

import org.apache.commons.mail.*;
import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Menu");
        System.out.println("1. Send the message");
        System.out.println("2. Send a message with attachment");
        System.out.println("3. Read the message");
        Scanner scanner = new Scanner(System.in);
        switch(scanner.nextInt()) {
            case 1:
                System.out.println("Client simplu de posta – trimitere mesaj");

                try {
                    Email email = new SimpleEmail();
                    email.setHostName("127.0.0.1");
                    email.setSmtpPort(25);
                    email.setFrom("b@mail.md");
                    email.setSubject("Mesaj de la mine pentru tine");
                    email.setMsg("Mesaj frumos si fragut!");
                    email.addTo("ana@mail.md");
                    email.send();
                } catch (EmailException var8) {
                    var8.printStackTrace();
                }
                break;
            case 2:
                System.out.println("Client simplu de posta – trimitere mesaj cu ata?ament");

                try {
                    EmailAttachment attachment = new EmailAttachment();
                    attachment.setPath("D:\\UTM\\Anul 3\\PR\\Lab#4\\pr_lab4/UTM.png");
                    attachment.setDisposition("attachment");
                    attachment.setDescription("Picture of John");
                    attachment.setName("John");
                    MultiPartEmal email = new MultiPartEmail();
                    email.setHostName("127.0.0.1");
                    email.setFrom("b@mail.md");
                    email.setSubject("The picture");
                    email.setMsg("Here is the picture you wanted");
                    email.addTo("ana@mail.md");
                    email.attach(attachment);
                    email.send();
                } catch (EmailException var7) {
                    var7.printStackTrace();
                }
                break;
            case 3:
                System.out.println("Client simplu de posta – citire mesaj");

                try {
                    POP3Client client = new POP3Client();
                    client.connect("127.0.0.1", 110);
                    if (client.login("ana", "ana")) {
                        POP3MessageInfo[] messages = client.listMessages();
                        System.out.println("Mesaje: " + messages.length);
                        System.out.println("Textul mesajului");
                        Reader r = client.retrieveMessage(messages[8].number);
                        BufferedReader br = new BufferedReader(r);

                        String line;
                        while((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    } else {
                        System.out.println("Logare fara succes...");
                    }

                    client.logout();
                    client.disconnect();
                } catch (IOException var9) {
                }
                break;
            default:
                System.out.println("Default choice");
        }

    }
}
```
### Rezultatul rularii
![Fig1](images\Fig1.png)</br>
![Fig2](images\Fig2.png)</br>
![Fig3](images\Fig3.png)</br>
![Fig4](images\Fig4.png)</br>
![Fig5](images\Fig5.png)</br>
![Fig6](images\Fig6.png)</br>
![Fig7](images\Fig7.png)</br>
![Fig8](images\Fig8.png)</br>
![Fig9](images\Fig9.png)</br>

