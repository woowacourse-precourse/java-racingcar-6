package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.CarsFixture;
import racingcar.application.RandomDriveRule;
import racingcar.controller.ConsoleInputOutput;
import racingcar.domain.policy.DriveRule;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameTest {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    @Test
    @DisplayName("게임은 정상적으로 실행되어야 한다.")
    void 게임은_정상적으로_실행() {
        DriveRule driveRule = mock(RandomDriveRule.class);
        GameOperator gameOperator = mock(ConsoleInputOutput.class);

        when(driveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(5, 2, 5);
        when(gameOperator.generateCars()).thenReturn(CarsFixture.fixture().build());
        when(gameOperator.setTrial()).thenReturn(1);

        Game game = new Game(driveRule, gameOperator);
        String result = game.run();

        assertEquals(
                """
                        First : -
                        Secon :\s
                        Third : -
                                                 
                        최종 우승자 : First, Third\
                        """
                , result);
    }
}