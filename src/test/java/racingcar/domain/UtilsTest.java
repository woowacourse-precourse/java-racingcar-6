package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class UtilsTest {
        @Test
        void 시도할_회수는_자연수만_가능합니다() {
            assertFalse(Utils.isNaturalNumber("-1"));
            assertFalse(Utils.isNaturalNumber("0"));
            assertFalse(Utils.isNaturalNumber("1.5"));
        }

    @Test
    void 랜덤_숫자_범위_테스트() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int randomNumber = Utils.getRandomNumber();
            randomNumbers.add(randomNumber);
        }
        assertThat(randomNumbers).contains(0,9);
    }
}