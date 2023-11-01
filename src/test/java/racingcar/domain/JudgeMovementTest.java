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
    void 전진_조건_확인() {
        int[] positions = new int[]{0, 0, 0};
        int[] randomNumbers = new int[]{5, 3, 7};
        JudgeMovement judgeMovement = new JudgeMovement();

        judgeMovement.moveForward(positions, randomNumbers);

        assertArrayEquals(new int[]{1, 0, 1}, positions);
    }
}