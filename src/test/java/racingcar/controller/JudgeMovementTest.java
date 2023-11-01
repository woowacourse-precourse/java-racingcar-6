package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests class JudgeMovement method function correctly
 */
class JudgeMovementTest {

    /**
     * Tests method goFlag returns true when right condition
     */
    @Test
    void goFlagTrueTest() {
        // given
        int randomNumber = 5;
        int criteria = 4;

        // when
        boolean flag = JudgeMovement.goFlag(randomNumber, criteria);

        // then
        assertThat(flag).isTrue();
    }

    /**
     * Tests method goFlag returns false when right condition
     */
    @Test
    void goFlagFalseTest() {
        // given
        int randomNumber = 5;
        int criteria = 7;

        // when
        boolean flag = JudgeMovement.goFlag(randomNumber, criteria);

        // then
        assertThat(flag).isFalse();
    }
}