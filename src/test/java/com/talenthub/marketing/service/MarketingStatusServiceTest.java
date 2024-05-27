package com.talenthub.marketing.service;

import com.talenthub.marketing.model.Marketingstatus;
import com.talenthub.marketing.repository.MarketingstatusRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MarketingStatusServiceTest {

    @Mock
    MarketingstatusRepository marketingstatusRepository;

    @InjectMocks
    MarketingStatusService marketingStatusService;

    @Test
    public void testFindById() {
        Marketingstatus status = new Marketingstatus();
        status.setId(1);
        status.setDescription("Status 1");

        when(marketingstatusRepository.findById(1)).thenReturn(Optional.of(status));

        Marketingstatus result = marketingStatusService.findById(1);

        assertEquals(1, result.getId());
        assertEquals("Status 1", result.getDescription());
    }

    @Test
    public void testFindAll() {
        Marketingstatus status1 = new Marketingstatus();
        status1.setId(1);
        status1.setDescription("Status 1");

        Marketingstatus status2 = new Marketingstatus();
        status2.setId(2);
        status2.setDescription("Status 2");

        List<Marketingstatus> statuses = Arrays.asList(status1, status2);

        when(marketingstatusRepository.findAll()).thenReturn(statuses);

        List<Marketingstatus> result = marketingStatusService.findAll();

        assertEquals(2, result.size());
        assertEquals("Status 1", result.get(0).getDescription());
        assertEquals("Status 2", result.get(1).getDescription());
    }

    @Test
    public void testSave() {
        Marketingstatus status = new Marketingstatus();
        status.setId(1);
        status.setDescription("Status 1");

        when(marketingstatusRepository.findByDescription("Status 1")).thenReturn(Arrays.asList());
        when(marketingstatusRepository.save(status)).thenReturn(status);

        Marketingstatus result = marketingStatusService.save(status);

        assertNotNull(result);
        assertEquals("Status 1", result.getDescription());
    }

    @Test
    public void testDeleteById() {
        doNothing().when(marketingstatusRepository).deleteById(1);

        Boolean result = marketingStatusService.deleteById(1);

        assertTrue(result);
    }
}
