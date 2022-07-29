package com.cts.dailynav.dailynav.controller;

import com.cts.dailynav.dailynav.feign.AuthorisingClient;
import com.cts.dailynav.dailynav.model.MutualFundDetails;
import com.cts.dailynav.dailynav.service.MutualFundDetailsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
public class MutualFundNavControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MutualFundDetailsService service;
    @MockBean
    private AuthorisingClient authClient;

    @Test
    void test1() {
        assertThat(service).isNotNull();
    }
    @Test
    void test2() {
        assertThat(authClient).isNotNull();
    }
    @Test
    void dailyNavWithWrongToken() throws Exception {
        when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
        this.mockMvc.perform(get("/mutualFundNav/Axis Mutual Fund").header("Authorization", "@WrongToken"))
                .andExpect(status().isUnauthorized());
    }
    @Test
    void dailyNavWithCorrectToken() throws Exception {
        when(authClient.authorizeTheRequest("@uthoriz@tionToken123")).thenReturn(true);
        this.mockMvc
                .perform(get("/mutualFundNav/Axis Mutual Fund").header("Authorization", "@uthoriz@tionToken123"))
                .andExpect(status().isOk());
    }
}
