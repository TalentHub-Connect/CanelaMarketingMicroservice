package com.talenthub.marketing.service;

import com.talenthub.marketing.model.Marketingstatus;
import com.talenthub.marketing.model.Possibleclient;
import com.talenthub.marketing.repository.PossibleClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PossibleClienteServiceTest {

    @Mock
    PossibleClienteRepository possibleClienteRepository;

    @Mock
    MarketingStatusService marketingStatusService;

    @InjectMocks
    PossibleClienteService possibleClienteService;

    @Test
    public void testSavePossibleclient() {
        Possibleclient client = new Possibleclient();
        client.setEmail("test@example.com");
        client.setNombre("Test Client");
        client.setPhonecontact(1234567890L);
        client.setMenssage("Test Message");
        client.setMarketingstatusid(1);

        when(marketingStatusService.findById(1)).thenReturn(new Marketingstatus());
        when(possibleClienteRepository.save(client)).thenReturn(client);

        Possibleclient result = possibleClienteService.savePossibleclient(client);

        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
    }

    @Test
    public void testFindAll() {
        Possibleclient client1 = new Possibleclient();
        client1.setEmail("client1@example.com");
        client1.setNombre("Client 1");
        client1.setPhonecontact(1234567890L);
        client1.setMenssage("Message 1");
        client1.setMarketingstatusid(1);

        Possibleclient client2 = new Possibleclient();
        client2.setEmail("client2@example.com");
        client2.setNombre("Client 2");
        client2.setPhonecontact(1234567891L);
        client2.setMenssage("Message 2");
        client2.setMarketingstatusid(2);

        List<Possibleclient> clients = Arrays.asList(client1, client2);

        when(possibleClienteRepository.findAll()).thenReturn(clients);

        List<Possibleclient> result = possibleClienteService.findAll();

        assertEquals(2, result.size());
        assertEquals("client1@example.com", result.get(0).getEmail());
        assertEquals("client2@example.com", result.get(1).getEmail());
    }

    @Test
    public void testSaveAll() {
        Possibleclient client1 = new Possibleclient();
        client1.setEmail("client1@example.com");
        client1.setNombre("Client 1");
        client1.setPhonecontact(1234567890L);
        client1.setMenssage("Message 1");
        client1.setMarketingstatusid(1);

        Possibleclient client2 = new Possibleclient();
        client2.setEmail("client2@example.com");
        client2.setNombre("Client 2");
        client2.setPhonecontact(1234567891L);
        client2.setMenssage("Message 2");
        client2.setMarketingstatusid(2);

        List<Possibleclient> clients = Arrays.asList(client1, client2);

        when(possibleClienteRepository.saveAll(clients)).thenReturn(clients);

        List<Possibleclient> result = possibleClienteService.saveAll(clients);

        assertEquals(2, result.size());
        assertEquals("client1@example.com", result.get(0).getEmail());
        assertEquals("client2@example.com", result.get(1).getEmail());
    }
}
