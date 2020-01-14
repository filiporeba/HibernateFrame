package shop.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import shop.model.Client;
import shop.service.ClientService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/clients")
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping(value = "/clients/{id}")
    public Client getClient(@PathVariable("id") Integer id) {
        return clientService.getClientById(id);
    }

    @PostMapping(value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @DeleteMapping(value = "/clients/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClientById(id);
    }

    @PutMapping(value = "/clients")
    public Client updateClient(@RequestBody @Valid Client client) {
        return clientService.addClient(client);
    }
}
