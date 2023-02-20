package org.pfe.bankbackend.repositories;

import org.pfe.bankbackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("select c from Client c where c.name like :kw")
    List<Client> searchClient(@Param("kw") String keyword);
}
