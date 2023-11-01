package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RefereeTest {
    private Referee referee;
    private static final List<String> CARS = Arrays.asList("andy", "pobi", "woni", "joy", "grace", "hoya");

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @Test
    void compare_단독우승() {
        List<Integer> racingResult = Arrays.asList(1, 5, 3, 5, 2, 9);
        String result = referee.compare(CARS, racingResult);

        assertThat(result).isEqualTo("hoya");

    }

    @Test
    void compare_공동우승() {
        List<Integer> racingResult = Arrays.asList(1, 5, 3, 5, 2, 1);
        String result = referee.compare(CARS, racingResult);

        assertThat(result).isEqualTo("pobi,joy");

    }

    @Test
    void findAllIndexOf_특정값의_인덱스_모두_찾기() {
        int value = 5;
        List<Integer> racingResult = Arrays.asList(1, 5, 3, 5, 2, 1);
        List<Integer> result = referee.findAllIndexOf(value, racingResult);

        assertThat(result).containsExactly(1, 3);
    }

}