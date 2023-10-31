package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class NumberGeneraotrTest {

    @Test
    void checkMoreThanFour_메서드_테스트() {
        int input = Randoms.pickNumberInRange(0, 9);
        NumberGenerator numberGenerator = new NumberGenerator();

        if (input > 4) {
            assertThat(numberGenerator.checkMoreThanFour(input)).isEqualTo(true);
        }else {
            assertThat(numberGenerator.checkMoreThanFour(input)).isEqualTo(false);
        }
    }
}
