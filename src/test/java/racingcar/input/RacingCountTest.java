package racingcar.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.input.InputValidatorTest.InputValidator;
import racingcar.output.MessageTypeTest.MessageType;
import racingcar.output.OutputCarRaceTest.OutputCarRace;

public class RacingCountTest {
    private static String 사용자_이동_횟수 = "";

    public void 사용자_이동_횟수를_입력하라() {
        this.사용자_이동_횟수 = "1000000";
    }

    public static class RacingCount {
        private int raceCount;

        public static RacingCount inputRaceCount(final String stringMoveCount) {
            return new RacingCount(stringMoveCount);
        }

        private RacingCount(final String stringMoveCount) {
            OutputCarRace.printf(MessageType.INPUT_CAR_RACING_COUNT_PRINT);
            InputValidator.validateRaceCount(stringMoveCount);

            raceCount = Integer.parseInt(stringMoveCount);
            OutputCarRace.printf(MessageType.INPUT_DATA_PRINT, stringMoveCount);
        }

        public int getRaceCount() {
            return raceCount;
        }

    }

    @Test
    void 사용자이동횟수_입력_정상() {
        사용자_이동_횟수를_입력하라();

        RacingCount racingCount = RacingCount.inputRaceCount(사용자_이동_횟수);
        int raceCount = racingCount.getRaceCount();

        assertThat(raceCount).isGreaterThan(0);
    }
}
