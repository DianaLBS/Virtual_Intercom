package controladores;

import connection.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javax.activation.FileDataSource;
import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import java.util.Properties;


public class ResidentController {

    //Variables para uso de email
    private static  String emailFrom="hotelvangoghclient00@gmail.com";
    private static String passwordFrom="vpurqcprmfhroujk";
    private static String emailTo= "alexandraarenas1705@gmail.com";
    private static String subject="Panic button of the apartament";
    private static String content ="The resident has pressed the panic button. He is in danger.";

    private String ipResident="";
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    //

    @FXML
    private TextField IPaddressDTF;

    @FXML
    private TextField message_TF;;

    @FXML
    private Button alert;

    @FXML
    private TextArea chatScreen;

    @FXML
    private Button initChat;

    @FXML
    private Button playIP;

    @FXML
    private Button sendMessage;

    @FXML
    void PressButtonPanic(ActionEvent event) {
        createEmail();
        sendEmail();
    }

    @FXML
    void actionPlayip(ActionEvent event) {

        ipResident= IPaddressDTF.getText();


        new Thread(()->{
            while(true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("si");
                Client cliente = new Client();
                cliente.startConnect(ipResident,"1","",-1);

            }
        }).start();
    }

    //enviar mensaje
    @FXML
    void sendMessage(ActionEvent event) {


        new Thread(()->{
            while(true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("si");
                Client cliente = new Client();
                cliente.startConnect(ipResident,"1",message_TF.getText(),4);


            }
        }).start();
    }
    public ResidentController() {
        mProperties = new Properties();
    }


    private void createEmail() {
        //Simple mail transfer Protocol SMTP

        mProperties.put("mail.smtp.host","smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user",emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        BodyPart texto = new MimeBodyPart();
        try {
            texto.setText(content);
        } catch (MessagingException e3) {
            // TODO Auto-generated catch block
            e3.printStackTrace();
        }
        BodyPart adjunto = new MimeBodyPart();
        try {
            adjunto.setDataHandler(new DataHandler(new FileDataSource("src/main/java/Images/ImagePanicMessage.jpg")));
        } catch (MessagingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            adjunto.setFileName("ImagePanicMessage.jpg");
        } catch (MessagingException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        MimeMultipart m = new MimeMultipart();
        try {
            m.addBodyPart(texto);
        } catch (MessagingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            m.addBodyPart(adjunto);
        } catch (MessagingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        mSession= Session.getDefaultInstance(mProperties);


        mCorreo= new MimeMessage(mSession);
        try {
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setContent(m);

        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom,passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            JOptionPane.showMessageDialog(null, "Correo Enviado al contacto de emergencia");
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }





}