package org.pfe.bankbackend.mappers;

import org.pfe.bankbackend.dtos.AccountOperationDTO;
import org.pfe.bankbackend.dtos.ClientDTO;
import org.pfe.bankbackend.dtos.CurrentBankAccountDTO;
import org.pfe.bankbackend.dtos.SavingBankAccountDTO;
import org.pfe.bankbackend.entities.AccountOperation;
import org.pfe.bankbackend.entities.Client;
import org.pfe.bankbackend.entities.CurrentAccount;
import org.pfe.bankbackend.entities.SavingAccount;

public interface BankAccountMapper {
    ClientDTO fromClient(Client client);

    Client fromClientDTO(ClientDTO clientDTO);

    SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount);

    SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO savingBankAccountDTO);

    CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount);

    CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO);

    AccountOperationDTO fromAccountOperation(AccountOperation accountOperation);
}
