package org.pfe.bankbackend.web;

import org.pfe.bankbackend.dtos.*;
import org.pfe.bankbackend.exceptions.BalanceNotSufficientException;
import org.pfe.bankbackend.exceptions.BankAccountNotFoundException;
import org.pfe.bankbackend.exceptions.ClientNotFoundException;
import org.pfe.bankbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class BankAccountRestAPI {
    private final BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/accounts/saving")
    public  SavingBankAccountDTO saveSavingBankAccount(@RequestBody SavingBankAccountDTO savingBankAccountDTO) throws ClientNotFoundException {
        return bankAccountService.saveSavingBankAccount(savingBankAccountDTO.getBalance(), savingBankAccountDTO.getInterestRate(), savingBankAccountDTO.getClientDTO().getId());
    }

    @PostMapping("/accounts/current")
    public CurrentBankAccountDTO saveCurrentBankAccount(@RequestBody CurrentBankAccountDTO currentBankAccountDTO) throws ClientNotFoundException {
        return bankAccountService.saveCurrentBankAccount(currentBankAccountDTO.getBalance(), currentBankAccountDTO.getOverDraft(), currentBankAccountDTO.getClientDTO().getId());
    }
    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }
    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts(){
        return bankAccountService.bankAccountList();
    }

    @GetMapping("/clients/{clientId}/accounts")
    public List<BankAccountDTO> listClientAccounts(@PathVariable Long clientId) throws ClientNotFoundException {
        return bankAccountService.bankAccountClientList(clientId);
    }

    @GetMapping("/clients/{clientId}/accounts/{accountId}")
    public BankAccountDTO getClientBankAccount(@PathVariable Long clientId,@PathVariable String accountId) throws BankAccountNotFoundException, ClientNotFoundException {
        return bankAccountService.getClientBankAccount(accountId,clientId);
    }

    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name="page",defaultValue = "0") int page,
            @RequestParam(name="size",defaultValue = "5")int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId,page,size);
    }
    @GetMapping("/clients/{clientId}/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getClientAccountHistory(
            @PathVariable String accountId,
            @PathVariable Long clientId,
            @RequestParam(name="page",defaultValue = "0") int page,
            @RequestParam(name="size",defaultValue = "5")int size) throws BankAccountNotFoundException, ClientNotFoundException {
        return bankAccountService.getClientAccountHistory(accountId,clientId,page,size);
    }
    @PostMapping("/accounts/debit")
    public DebitDTO debit(@RequestBody DebitDTO debitDTO) throws BankAccountNotFoundException, BalanceNotSufficientException {
        this.bankAccountService.debit(debitDTO.getAccountId(),debitDTO.getAmount(),debitDTO.getDescription());
        return debitDTO;
    }
    @PostMapping("/accounts/credit")
    public CreditDTO credit(@RequestBody CreditDTO creditDTO) throws BankAccountNotFoundException {
        this.bankAccountService.credit(creditDTO.getAccountId(),creditDTO.getAmount(),creditDTO.getDescription());
        return creditDTO;
    }
    @PostMapping("/accounts/transfer")
    public TransferRequestDTO transfer(@RequestBody TransferRequestDTO transferRequestDTO) throws BankAccountNotFoundException, BalanceNotSufficientException {
        this.bankAccountService.transfer(
                transferRequestDTO.getAccountSource(),
                transferRequestDTO.getAccountDestination(),
                transferRequestDTO.getAmount());
        return transferRequestDTO;
    }
}


