package com.example.demo.controllers;

import com.example.demo.dtos.RegisterDTO;
import com.example.demo.models.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @GetMapping
    public ResponseEntity<?> getClients(){
        var clients = clientRepository.findAll().stream().toList();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentClient(){
        var mail = SecurityContextHolder.getContext().getAuthentication().getName();
        var client = clientRepository.findByEmail(mail);
        return ResponseEntity.ok(client);
    }


}
