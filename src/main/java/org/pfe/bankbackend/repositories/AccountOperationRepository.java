package org.pfe.bankbackend.repositories;

import org.pfe.bankbackend.entities.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
    List<AccountOperation> findByBankAccountId(String accountId);
    Page<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable);
    Page<AccountOperation> findByBankAccountIdAndBankAccount_Client_IdOrderByOperationDateDesc(String accountId,Long clientId, Pageable pageable);

}