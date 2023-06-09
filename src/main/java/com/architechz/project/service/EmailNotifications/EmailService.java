package com.architechz.project.service.EmailNotifications;

import org.springframework.http.ResponseEntity;

import com.architechz.project.payload.Emails.NewUser;


public interface EmailService {
    
    public ResponseEntity<?> newUser(NewUser NewuserNotification);
    public ResponseEntity<?> ForgotPassword(String Username, String token);
    public ResponseEntity<?> Verify(String Username, String token);
    public ResponseEntity<?> sendMessagge(String username, String subject, String messagge);
    
}
