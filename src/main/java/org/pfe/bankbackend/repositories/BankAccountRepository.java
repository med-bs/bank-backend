package org.pfe.bankbackend.repositories;

import org.pfe.bankbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    List<BankAccount> findByClient_Id(Long clientId);

    Optional<BankAccount> findByIdAndClient_Id(String id, Long clientId);
}
