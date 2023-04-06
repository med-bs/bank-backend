package org.pfe.bankbackend.services;

import org.pfe.bankbackend.dtos.*;
import org.pfe.bankbackend.exceptions.BalanceNotSufficientException;
import org.pfe.bankbackend.exceptions.BankAccountNotFoundException;
import org.pfe.bankbackend.exceptions.ClientNotFoundException;

import java.util.List;

public interface BankAccountService {
    ClientDTO saveClient(ClientDTO clientDTO);

    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long clientId) throws ClientNotFoundException;

    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long clientId) throws ClientNotFoundException;

    List<ClientDTO> listClients();

    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    BankAccountDTO getClientBankAccount(String accountId, Long clientId) throws BankAccountNotFoundException, ClientNotFoundException;

    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;

    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;

    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();
    List<BankAccountDTO> bankAccountClientList(Long clientId) throws ClientNotFoundException;
    ClientDTO getClient(Long clientId) throws ClientNotFoundException;

    ClientDTO updateClient(ClientDTO clientDTO);

    void deleteClient(Long clientId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
    AccountHistoryDTO getClientAccountHistory(String accountId,Long clientId, int page, int size) throws BankAccountNotFoundException, ClientNotFoundException;

    List<ClientDTO> searchClients(String keyword);
}
