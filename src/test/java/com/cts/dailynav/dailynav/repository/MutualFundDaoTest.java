package com.cts.dailynav.dailynav.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class MutualFundDaoTest {
    @Autowired
    private MutualFundDao mutualFundDao;

    @Test
    void testGetFundByName() {
        assertNotNull(mutualFundDao.findByMutualFundName("Axis Mutual Fund"));
    }
    @Test
    void testGetFundByWrongName() {
        assertNull(mutualFundDao.findByMutualFundName("SBI Mutual Fund"));
    }
}
