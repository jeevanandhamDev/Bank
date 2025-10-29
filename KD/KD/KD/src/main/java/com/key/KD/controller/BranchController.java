package com.key.KD.controller;

import com.key.KD.model.Branch;
import com.key.KD.repo.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BranchController {

    @Autowired
    BranchRepo branchRepo;

    @PostMapping("/api/admin/branch-add")
    public ResponseEntity<String> addBranch(@RequestBody Branch branch){
        try {
            branchRepo.save(branch);
            return new ResponseEntity<>("New branch Added Successfully!",HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/public/branch-show")
    public List<Branch> showBranches(){
        return branchRepo.findAll();
    }
}
