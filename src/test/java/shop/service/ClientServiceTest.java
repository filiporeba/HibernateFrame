package shop.service;


import org.junit.Before;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import shop.model.Client;
import shop.repository.ClientRepo;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    @Mock
    ClientRepo clientRepo;

    @InjectMocks
    ClientService clientService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    private final Client exampleClient = new Client(1, "Test", "Test", "adress", "male", 132L, 33);

    private List<Client> clientMockList() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "Test", "Test", "adress", "male", 132L, 33));
        clients.add(new Client(3, "Name", "Surname", "Somewhere", "male", 55L, 11));
        return clients;
    }

    @Test
    public void shouldAddClient() {
        when(clientRepo.save(exampleClient)).thenReturn(exampleClient);

        Client clientt = clientService.addClient(exampleClient);

        assertNotNull(clientt);
        assertThat(clientt).isEqualTo(exampleClient);
    }

    @Test
    public void shouldCountTwoObjectsInList() {
        when(clientRepo.findAll()).thenReturn(clientMockList());

        List<Client> allClients = clientService.getAllClients();

        assertEquals(2, allClients.size());
    }


    @Test(expected = EmptyResultDataAccessException.class)
    public void shouldThrowExceptionToFindPersonWithIdZero() {
        doThrow(EmptyResultDataAccessException.class).when(clientRepo).deleteById(0);

        clientService.deleteClientById(0);
    }


    @Test
    public void shouldFindClientWithIdOne() {
        when(clientRepo.findById(1)).thenReturn(java.util.Optional.of(exampleClient));

        Client expectedClient = clientService.getClientById(1);

        assertThat(expectedClient).isEqualTo(expectedClient);
    }
}