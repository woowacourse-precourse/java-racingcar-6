package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TryCountTest {

    @Test
    void getTryCountTest() {
        TryCount tryCount = new TryCount("1");

        assertEquals(1, tryCount.getTryCount());
    }
}