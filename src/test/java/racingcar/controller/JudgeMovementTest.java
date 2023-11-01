package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JudgeMovementTest {
    @Test
    void goFlagTrueTest() {
        int randomNumber = 5;
        int c = 4;

        boolean flag = JudgeMovement.goFlag(randomNumber, c);

        assertThat(flag).isTrue();
    }

    @Test
    void goFlagFalseTest() {
        int randomNumber = 5;
        int c = 7;

        boolean flag = JudgeMovement.goFlag(randomNumber, c);

        assertThat(flag).isFalse();
    }
}