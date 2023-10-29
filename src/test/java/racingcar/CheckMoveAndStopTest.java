package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class CheckMoveAndStopTest {

    static class CheckMoveAndStop{
        private static final int START_INCLUSIVE = 0;
        private static final int END_INCLUSIVE = 9;

        public static boolean isMove(){
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

            return randomNumber >= 4;
        }
    }

    @Test
    void 무작위_값조회(){
        assertThat(CheckMoveAndStop.isMove()).isNotNull();
    }
}