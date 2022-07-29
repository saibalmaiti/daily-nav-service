package com.cts.dailynav.dailynav.service;

import com.cts.dailynav.dailynav.exception.MutualFundNameNotFoundException;
import com.cts.dailynav.dailynav.model.MutualFundDetails;
import com.cts.dailynav.dailynav.repository.MutualFundDao;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MutualFundDetailsServiceTest {
    @Mock
    private MutualFundDao mutualFundDao;
    @InjectMocks
    private MutualFundDetailsService service;

    @Test
    void getMutualFundDetailsTest() throws MutualFundNameNotFoundException {
        MutualFundDetails mutualFundDetails = new MutualFundDetails(2,"Axis Mutual Fund",65.83);
        when(mutualFundDao.findByMutualFundName("Axis Mutual Fund")).thenReturn(mutualFundDetails);
        assertEquals(service.getMutualFundDetails("Axis Mutual Fund"),mutualFundDetails);
    }
    @Test
    void getMutualFundDetailsException() throws MutualFundNameNotFoundException {
        when(mutualFundDao.findByMutualFundName("SBI Mutual Fund")).thenReturn(null);
        assertThrows(MutualFundNameNotFoundException.class, ()->{
            service.getMutualFundDetails("SBI Mutual Fund");
        });
    }
}
