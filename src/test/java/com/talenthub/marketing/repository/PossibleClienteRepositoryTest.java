package com.talenthub.marketing.repository;

import com.talenthub.marketing.model.Possibleclient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class PossibleClienteRepositoryTest {

    @Autowired
    private PossibleClienteRepository possibleClienteRepository;

    @Test
    public void testSaveAndFindById() {
        Possibleclient client = new Possibleclient();
        client.setEmail("test@example.com");
        client.setNombre("Test Client");
        client.setPhonecontact(1234567890L);
        client.setMenssage("Test Message");
        client.setMarketingstatusid(1);
        possibleClienteRepository.save(client);

        Possibleclient found = possibleClienteRepository.findById("test@example.com").orElse(null);

        assertNotNull(found);
        assertEquals("Test Client", found.getNombre());
    }
}
