package com.cts.dailynav.dailynav.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MutualFunDetailsTest {
    @Test
    void MutualFundWithNoArgument() {
        assertThat(new MutualFundDetails()).isNotNull();
    }
    @Test
    void MutualFundWithArgumnet() {
        assertThat(new MutualFundDetails(1,"Axis Mutual Fund",65.54)).isNotNull();
    }
}
