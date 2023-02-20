package org.pfe.bankbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class SavingAccount extends BankAccount {
    private double interestRate;
}