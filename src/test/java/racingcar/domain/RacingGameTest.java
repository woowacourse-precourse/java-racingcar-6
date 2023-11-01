package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RacingGameTest {
    @Mock
    MovingCondition movingCondition;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        movingCondition = Mockito.mock(MovingCondition.class);
        racingGame = new RacingGame(movingCondition);
    }

    @Test
    @DisplayName("전진 횟수 확인")
    void testRace() {
        List<String> carNames = Arrays.asList("pobi");
        int attemptCount = 3;

        when(movingCondition.getRandomNumber())
                .thenReturn(1)
                .thenReturn(8)
                .thenReturn(4);
        when(movingCondition.isMovingForward(1)).thenReturn(false);
        when(movingCondition.isMovingForward(8)).thenReturn(true);
        when(movingCondition.isMovingForward(4)).thenReturn(true);

        List<String> result = racingGame.race(carNames, attemptCount);

        assertEquals(2, result.get(0).length());
    }
}