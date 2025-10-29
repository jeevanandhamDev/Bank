package com.key.KD.controller;

import com.key.KD.model.AccountHolder;
import com.key.KD.repo.AccountHolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountHolderController {

    @Autowired
    AccountHolderRepo accountHolderRepo;

    @PostMapping("/api/admin/account-add")
    public ResponseEntity<String> addAccount(@RequestBody AccountHolder accountHolder){
        try{
            accountHolderRepo.save(accountHolder);
            return new ResponseEntity<>("Account Added", HttpStatus.CREATED);
        }

        catch(Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/api/admin/accounts")
    public List<AccountHolder> showAccounts(){
        return accountHolderRepo.findAll();
    }
}
