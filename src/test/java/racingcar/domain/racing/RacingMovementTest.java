package racingcar.domain.racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

class RacingMovementTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;

    @RepeatedTest(5)
    @DisplayName("전진하는 조건은 무작위 값이 4 이상 테스트")
    @Test
    void isMovingForward() {

        // Arrange
        Integer randomNumber = RandomNumberGenerator.pinkInRange(MOVING_FORWARD, RANDOM_NUMBER_END);
        RacingMovement racingMovement = new RacingMovement("pobi", randomNumber);

        // Act & Assert
        Assertions.assertTrue(racingMovement.isMovingForward());
    }

    @RepeatedTest(5)
    @DisplayName("멈추는 조건은 무작위 값이 4 미만 테스트")
    @Test
    void isStop() {

        // Arrange
        Integer randomNumber = RandomNumberGenerator.pinkInRange(RANDOM_NUMBER_START, STOP );
        RacingMovement racingMovement = new RacingMovement("pobi", randomNumber);

        // Act & Assert
        Assertions.assertTrue(racingMovement.isStop());
    }
}