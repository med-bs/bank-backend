package org.pfe.bankbackend.repositories;

import org.pfe.bankbackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
