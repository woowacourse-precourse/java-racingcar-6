package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class WinnerTest {
    Map<String, Integer> car, car2;
    @BeforeEach
    void setUp() {
        car = new HashMap<>();
        car2 = new HashMap<>();
    }

    @Test
    @DisplayName("전진한 자동차의 최대값")
    void maxForwardCount() {
        car.put("pobi", 4);
        car.put("woni", 2);
        car.put("jun", 6);

        assertThat(Winner.maxForward(car)).isEqualTo(6);
    }

    @Test
    @DisplayName("우승한 이름 목록 구하기")
    void winnerList() {
        car.put("pobi", 5);
        car.put("woni", 5);
        car.put("jun", 2);

        car2.put("pobi", 3);
        car2.put("woni", 1);
        car2.put("jun", 2);

        int maxForwardCount = Collections.max(car.values());
        int maxForwardCount2 = Collections.max(car2.values());

        assertThat(Winner.winnerList(car, maxForwardCount)).contains(new String[] {"pobi", "woni"});
        assertThat(Winner.winnerList(car2, maxForwardCount2)).contains(new String[] {"pobi"});
    }
}