package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    public static class TestRacingCarGame extends RacingCarGame {
        @Override
        public boolean makeMoveDecision() {
            return true;
        }
    }

    @Test
    public void testGenerateRandomDashWhenMakeMoveDecisionIsTrue() {
        RacingCarGame racingCarGame = new TestRacingCarGame();
        String result = Calculator.generateRandomDash(racingCarGame);

        assertThat(result).isEqualTo("-");
    }
}