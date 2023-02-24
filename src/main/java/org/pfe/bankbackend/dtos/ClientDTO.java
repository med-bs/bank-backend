package org.pfe.bankbackend.dtos;

import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String email;
}
