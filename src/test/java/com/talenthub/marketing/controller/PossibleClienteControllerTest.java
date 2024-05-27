package com.talenthub.marketing.controller;

import com.talenthub.marketing.model.Possibleclient;
import com.talenthub.marketing.service.PossibleClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PossibleClienteControllerTest {

    @Mock
    PossibleClienteService possibleClienteService;

    @InjectMocks
    PossibleClienteController possibleClienteController;

    private MockMvc mockMvc;

    @Test
    public void testSavePossibleclient() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(possibleClienteController).build();

        Possibleclient client = new Possibleclient();
        client.setEmail("test@example.com");
        client.setNombre("Test Client");
        client.setPhonecontact(1234567890L);
        client.setMenssage("Test Message");
        client.setMarketingstatusid(1);

        when(possibleClienteService.savePossibleclient(client)).thenReturn(client);

        mockMvc.perform(post("/possibleclient/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"test@example.com\",\"nombre\":\"Test Client\",\"phonecontact\":1234567890,\"menssage\":\"Test Message\",\"marketingstatusid\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"email\":\"test@example.com\",\"nombre\":\"Test Client\",\"phonecontact\":1234567890,\"menssage\":\"Test Message\",\"marketingstatusid\":1}"));
    }

    @Test
    public void testFindAll() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(possibleClienteController).build();

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

        when(possibleClienteService.findAll()).thenReturn(clients);

        mockMvc.perform(get("/possibleclient/list"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"email\":\"client1@example.com\",\"nombre\":\"Client 1\",\"phonecontact\":1234567890,\"menssage\":\"Message 1\",\"marketingstatusid\":1},{\"email\":\"client2@example.com\",\"nombre\":\"Client 2\",\"phonecontact\":1234567891,\"menssage\":\"Message 2\",\"marketingstatusid\":2}]"));
    }

    @Test
    public void testSaveAll() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(possibleClienteController).build();

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

        when(possibleClienteService.saveAll(clients)).thenReturn(clients);

        mockMvc.perform(post("/possibleclient/saveAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[{\"email\":\"client1@example.com\",\"nombre\":\"Client 1\",\"phonecontact\":1234567890,\"menssage\":\"Message 1\",\"marketingstatusid\":1},{\"email\":\"client2@example.com\",\"nombre\":\"Client 2\",\"phonecontact\":1234567891,\"menssage\":\"Message 2\",\"marketingstatusid\":2}]"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"email\":\"client1@example.com\",\"nombre\":\"Client 1\",\"phonecontact\":1234567890,\"menssage\":\"Message 1\",\"marketingstatusid\":1},{\"email\":\"client2@example.com\",\"nombre\":\"Client 2\",\"phonecontact\":1234567891,\"menssage\":\"Message 2\",\"marketingstatusid\":2}]"));
    }
}
