package com.key.KD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_holder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolder {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String holderName;
    private String accountNumber;


    @ManyToOne()
    @JoinColumn(name= "branch_id", nullable = false)
    private Branch branch;
}
