package com.key.KD.controller;

import com.key.KD.model.Bank;
import com.key.KD.repo.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    private BankRepo bankRepo;

    @PostMapping("/api/admin/bank-add")
    public ResponseEntity<String> addBank(@RequestBody Bank bank){
        try{
            bankRepo.save(bank);
            return new ResponseEntity<>("Bank added!", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("api/public/bank-show")
    public List<Bank> getAllBanks() {
        return bankRepo.findAll();
    }
}
