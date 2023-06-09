package com.architechz.project.service.EmailNotifications;

import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.architechz.project.payload.Emails.NewUser;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String mallFrom;

    @Override
    public ResponseEntity<?> newUser(NewUser NewuserNotification) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
            mimeMessageHelper.setTo(NewuserNotification.getUsername());
            String url = " http://10.43.101.98/login"; // add login page
            mimeMessageHelper.setText(
                    "Hola " + NewuserNotification.getName()
                            + " bienvenido a IntelliTrack es un gusto contar contigo, \n a seguir se le brindara las credenciales para entrar a la aplicacion en el enlace "
                            + url + " : \n Username: " + NewuserNotification.getUsername() + "\n Contrasena: "
                            + NewuserNotification.getPassword());
            mimeMessageHelper.setSubject("Bienvenido a IntelliTrack");
            javaMailSender.send(mimeMessage);
            return ResponseEntity.ok("Correo enviado con exito al usuario " + NewuserNotification.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fue imposible mandar el correo en este momento");
        }
    }

    @Override
    public ResponseEntity<?> ForgotPassword(String username, String token) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
            mimeMessageHelper.setTo(username);

            String url = "http://10.43.101.98/change-password/" + token; // add login page
            mimeMessageHelper.setText(
                    "Hola, \n en el siguiente enlace podras actualizar tu contrasena: "
                            + url);
            mimeMessageHelper.setSubject("IntelliTrack cambio de contrasena");
            javaMailSender.send(mimeMessage);
            return ResponseEntity.ok("Correo para actualizar contrasena enviado con exito al usuario " + username);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fue imposible mandar el correo en este momento");
        }
    }

    @Override
    public ResponseEntity<?> Verify(String username, String token) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
            mimeMessageHelper.setTo(username);
            String url = "http://10.43.101.98/verify-email"; // add login page
            mimeMessageHelper.setText(
                    "Hola, \n el codigo es: " + token + " ingresalo en la siguiente pagina "
                            + url);
            mimeMessageHelper.setSubject("IntelliTrack verificar correo");
            javaMailSender.send(mimeMessage);
            return ResponseEntity.ok("Correo para verificar correo enviado con exito al email: " + username);
        } catch (Exception e) {
            return ResponseEntity.ok("Correo para verificar correo no enviado con exito al email: " + username);
        }
    }

    @Override
    public ResponseEntity<?> sendMessagge(String username, String subject, String messagge) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
            mimeMessageHelper.setTo(username);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(messagge);
            javaMailSender.send(mimeMessage);
            return ResponseEntity.ok("Mensaje enviado por correo con exito al usuario con correo: " + username);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fue imposible mandar el correo en este momento");
        }
    }
}
