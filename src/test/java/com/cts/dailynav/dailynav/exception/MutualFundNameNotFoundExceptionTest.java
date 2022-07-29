package com.cts.dailynav.dailynav.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MutualFundNameNotFoundExceptionTest {

    private MutualFundNameNotFoundException e = new MutualFundNameNotFoundException("message");
    @Test
    void testMessageSetter() {
        assertThat(e).isNotNull();
    }
}
