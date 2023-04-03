package org.pfe.bankbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pfe.bankbackend.dtos.ClientDTO;
import org.pfe.bankbackend.exceptions.ClientNotFoundException;
import org.pfe.bankbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/v2")
public class ClientRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/clients")
    public List<ClientDTO> clients(){
        return bankAccountService.listClients();
    }
    @GetMapping("/clients/search")
    public List<ClientDTO> searchClients(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return bankAccountService.searchClients("%"+keyword+"%");
    }
    @GetMapping("/clients/{id}")
    public ClientDTO getClient(@PathVariable(name = "id") Long clientId) throws ClientNotFoundException {
        return bankAccountService.getClient(clientId);
    }
    @PostMapping("/clients")
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO){
        return bankAccountService.saveClient(clientDTO);
    }
    @PutMapping("/clients/{clientId}")
    public ClientDTO updateClient(@PathVariable Long clientId, @RequestBody ClientDTO clientDTO){
        clientDTO.setId(clientId);
        return bankAccountService.updateClient(clientDTO);
    }
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id){
        bankAccountService.deleteClient(id);
    }
}
