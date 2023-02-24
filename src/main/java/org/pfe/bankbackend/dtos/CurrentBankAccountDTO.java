package org.pfe.bankbackend.dtos;

import lombok.Data;
import org.pfe.bankbackend.enums.AccountStatus;

import java.util.Date;

@Data
public class CurrentBankAccountDTO extends BankAccountDTO {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private ClientDTO clientDTO;
    private double overDraft;
}
