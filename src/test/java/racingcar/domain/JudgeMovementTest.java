package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeMovementTest {

    @Test
    void 랜덤_숫자_생성() {
        int carCount = 3;
        JudgeMovement judgeMovement = new JudgeMovement();

        int[] result = judgeMovement.createRandomNumbers(carCount);

        assertEquals(carCount, result.length);
    }

    @Test
    void moveForward() {
    }
}