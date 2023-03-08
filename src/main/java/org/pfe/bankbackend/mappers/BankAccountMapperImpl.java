package org.pfe.bankbackend.mappers;

import org.pfe.bankbackend.dtos.AccountOperationDTO;
import org.pfe.bankbackend.dtos.ClientDTO;
import org.pfe.bankbackend.dtos.CurrentBankAccountDTO;
import org.pfe.bankbackend.dtos.SavingBankAccountDTO;
import org.pfe.bankbackend.entities.AccountOperation;
import org.pfe.bankbackend.entities.Client;
import org.pfe.bankbackend.entities.CurrentAccount;
import org.pfe.bankbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class BankAccountMapperImpl implements BankAccountMapper {
    public ClientDTO fromClient(Client client){
        ClientDTO clientDTO=new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return  clientDTO;
    }
    public Client fromClientDTO(ClientDTO clientDTO){
        Client client=new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return  client;
    }

    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
        SavingBankAccountDTO savingBankAccountDTO=new SavingBankAccountDTO();
        BeanUtils.copyProperties(savingAccount,savingBankAccountDTO);
        savingBankAccountDTO.setClientDTO(fromClient(savingAccount.getClient()));
        savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
        return savingBankAccountDTO;
    }

    public SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO savingBankAccountDTO){
        SavingAccount savingAccount=new SavingAccount();
        BeanUtils.copyProperties(savingBankAccountDTO,savingAccount);
        savingAccount.setClient(fromClientDTO(savingBankAccountDTO.getClientDTO()));
        return savingAccount;
    }

    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
        CurrentBankAccountDTO currentBankAccountDTO=new CurrentBankAccountDTO();
        BeanUtils.copyProperties(currentAccount,currentBankAccountDTO);
        currentBankAccountDTO.setClientDTO(fromClient(currentAccount.getClient()));
        currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());
        return currentBankAccountDTO;
    }

    public CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
        CurrentAccount currentAccount=new CurrentAccount();
        BeanUtils.copyProperties(currentBankAccountDTO,currentAccount);
        currentAccount.setClient(fromClientDTO(currentBankAccountDTO.getClientDTO()));
        return currentAccount;
    }

    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO=new AccountOperationDTO();
        BeanUtils.copyProperties(accountOperation,accountOperationDTO);
        return accountOperationDTO;
    }

}
