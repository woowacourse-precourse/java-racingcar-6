package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest extends NsTest {
    private static RacingCars cars;

    @BeforeEach
    void before() {
        List<String> carNames = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        cars = new RacingCars(carNames);
    }

    @Test
    @DisplayName("자동차_움직임_테스트")
    void moveOrStop() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    Assertions.assertThat(cars.getCars())
                            .extracting("position")
                            .containsExactly(1, 0, 0);
                },
                5, 3, 2
        );
    }

    @Test
    @DisplayName("승자_찾기_테스트")
    void findWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    Assertions.assertThat(cars.findWinner())
                            .containsExactly("pobi");
                },
                5, 3, 2
        );
    }

    @Override
    protected void runMain() {
        cars.moveOrStop();
    }
}