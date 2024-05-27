package com.talenthub.marketing.controller;

import com.talenthub.marketing.model.Marketingstatus;
import com.talenthub.marketing.service.MarketingStatusService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MarketingStatusControllerTest {

    @Mock
    MarketingStatusService marketingStatusService;

    @InjectMocks
    MarketingStatusController marketingStatusController;

    private MockMvc mockMvc;

    @Test
    public void testFindAll() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(marketingStatusController).build();

        Marketingstatus status1 = new Marketingstatus();
        status1.setId(1);
        status1.setDescription("Status 1");

        Marketingstatus status2 = new Marketingstatus();
        status2.setId(2);
        status2.setDescription("Status 2");

        List<Marketingstatus> statuses = Arrays.asList(status1, status2);

        when(marketingStatusService.findAll()).thenReturn(statuses);

        mockMvc.perform(get("/marketingstatus/list"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"description\":\"Status 1\"},{\"id\":2,\"description\":\"Status 2\"}]"));
    }

    @Test
    public void testSave() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(marketingStatusController).build();

        Marketingstatus status = new Marketingstatus();
        status.setId(1);
        status.setDescription("Status 1");

        when(marketingStatusService.save(status)).thenReturn(status);

        mockMvc.perform(post("/marketingstatus/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"description\":\"Status 1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"description\":\"Status 1\"}"));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(marketingStatusController).build();

        when(marketingStatusService.deleteById(1)).thenReturn(true);

        mockMvc.perform(delete("/marketingstatus/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
