package racingcar.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class RacingCountTest {
    private static String 사용자_이동_횟수 = "";

    public void 사용자_이동_횟수를_입력하라() {
        this.사용자_이동_횟수 = "1000000";
    }

    public static class RacingCount {
        private int raceCount;

        public static RacingCount inputRaceCount(String stringMoveCount) {
            return new RacingCount(stringMoveCount);
        }

        public int getRaceCount() {
            return raceCount;
        }

        private RacingCount(String stringMoveCount) {
            raceCount = Integer.parseInt(stringMoveCount);
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
