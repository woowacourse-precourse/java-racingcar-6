package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttemptTest {

    @Test
    void isExist_0일_때_거짓_반환() {
        Attempt attempt = new Attempt(0);
        assertFalse(attempt.isExist());
    }

    @Test
    void isExist_1일_때_참_반환() {
        Attempt attempt = new Attempt(1);
        assertTrue(attempt.isExist());
    }

}