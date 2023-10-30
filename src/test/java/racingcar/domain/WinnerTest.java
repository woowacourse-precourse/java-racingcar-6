package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class WinnerTest {
    Map<String, Integer> car;
    @BeforeEach
    void setUp() {
        car = new HashMap<>();
    }

    @Test
    @DisplayName("전진한 자동차의 최대값")
    void maxForwardCount() {
        car.put("pobi", 4);
        car.put("woni", 2);
        car.put("jun", 6);
        assertThat(Collections.max(car.values())).isEqualTo(6);
    }
}