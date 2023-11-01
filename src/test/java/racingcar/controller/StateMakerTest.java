package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Racer;

class StateMakerTest {
    private static final int GO = 4;
    private static final int STOP = 3;

    @Test
    void 전진_판단_테스트() {
        // Give
        Racer testRacer = new Racer("testRacer");
        StateMaker.getGoOrStop(testRacer);

        // When

        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    StateMaker.getGoOrStop(testRacer);
                    assertThat(testRacer.getState()).isEqualTo(true);
            },
            GO
        );
    }

    @Test
    void 정지_판단_테스트() {
        // Give
        Racer testRacer = new Racer("testRacer");
        StateMaker.getGoOrStop(testRacer);

        // When

        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    StateMaker.getGoOrStop(testRacer);
                    assertThat(testRacer.getState()).isEqualTo(false);
                },
                STOP
        );
    }
}