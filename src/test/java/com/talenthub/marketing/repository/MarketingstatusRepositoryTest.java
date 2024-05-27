package com.talenthub.marketing.repository;

import com.talenthub.marketing.model.Marketingstatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class MarketingstatusRepositoryTest {

    @Autowired
    private MarketingstatusRepository marketingstatusRepository;

    @Test
    public void testFindByDescription() {
        Marketingstatus status = new Marketingstatus();
        status.setDescription("Test Description");
        marketingstatusRepository.save(status);

        List<Marketingstatus> found = marketingstatusRepository.findByDescription("Test Description");

        assertEquals(1, found.size());
        assertEquals("Test Description", found.get(0).getDescription());
    }
}
