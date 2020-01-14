package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.model.Client;
import shop.repository.ClientRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    public void deleteClientById(Integer id) {
        clientRepo.deleteById(id);
    }

    public Client getClientById(Integer id) {
        Optional<Client> byId = clientRepo.findById(id);
        return byId.orElse(null);
    }

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }


}
