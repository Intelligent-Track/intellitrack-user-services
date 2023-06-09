package com.architechz.project.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architechz.project.payload.Password.PasswordChange;
import com.architechz.project.payload.request.LoginRequest;
import com.architechz.project.payload.request.SignupRequest;
import com.architechz.project.payload.response.JwtResponse;
import com.architechz.project.payload.response.MessageResponse;
import com.architechz.project.repository.ClienteRepository;
import com.architechz.project.repository.RoleRepository;
import com.architechz.project.repository.UserRepository;
import com.architechz.project.security.jwt.JwtUtils;
import com.architechz.project.security.services.UserDetailsImpl;
import com.architechz.project.service.AuthService.AuthService;
import com.architechz.project.service.Clientes.ClienteService;
import com.architechz.project.service.ResetPassword.ResetPasswordService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  ClienteRepository clientRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  ClienteService clienteService;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  AuthService authService;

  @Autowired
  ResetPasswordService resetPasswordService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    if(clienteService.verifyPet(loginRequest) == "1"){
      return ResponseEntity.badRequest().body("Usuario aun no verificado, verifique el correo primero....");
    }else{
      if(clienteService.verifyPet(loginRequest) == "2"){
        return ResponseEntity.badRequest().body("Usuario aun no aprobado, una vez aprobado recibiras un correo confirmando....");
      }
    }

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
        userDetails.getId(),
        userDetails.getUsername(),
        userDetails.getName(),
        roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    return ResponseEntity.ok(new MessageResponse(authService.addUser(signUpRequest)));
  }

  @PostMapping("/forgotPassword")
  public ResponseEntity<?> ForgotPassword(@Valid @RequestBody PasswordChange password) {
    System.out.println(password.getUsername());
    return ResponseEntity.ok().body(resetPasswordService.PasswordUser(password));
  }

  @PostMapping("/ResetPassword/{token}")
  public ResponseEntity<?> ResetPassword(@PathVariable String token, @Valid @RequestBody PasswordChange password) {
    System.out.println("Este es el token " + token);
    return ResponseEntity.ok().body(resetPasswordService.ResetUser(password,token));
  }

}
