package racingcar.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.input.InputValidatorTest.InputValidator;
import racingcar.output.MessageTypeTest.MessageType;
import racingcar.output.OutputCarRaceTest.OutputCarRace;

public class RacingCountTest {
    private static String 경주_횟수 = "";

    public void 경주_횟수를_입력하라() {
        this.경주_횟수 = "1000000";
    }

    public static class RacingCount {
        private int raceCount;

        public static RacingCount inputRaceCount(final String stringRaceCount) {
            return new RacingCount(stringRaceCount);
        }

        private RacingCount(final String stringRaceCount) {
            OutputCarRace.printf(MessageType.INPUT_CAR_RACING_COUNT_PRINT);
            InputValidator.validateRaceCount(stringRaceCount);

            raceCount = Integer.parseInt(stringRaceCount);
            OutputCarRace.printf(MessageType.INPUT_DATA_PRINT, stringRaceCount);
        }

        public int getRaceCount() {
            return raceCount;
        }

    }

    @Test
    void 경주횟수_입력_정상() {
        경주_횟수를_입력하라();

        RacingCount racingCount = RacingCount.inputRaceCount(경주_횟수);
        int raceCount = racingCount.getRaceCount();

        assertThat(raceCount).isGreaterThan(0);
    }
}
