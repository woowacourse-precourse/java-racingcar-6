package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;;

class RandomNumberTest {
    @Test
    void 랜덤_숫자_생성_성공() {
        Integer start = 0;
        Integer end = 9;
        assertThatCode(() ->RandomNumber.fromInteger(start,end)).doesNotThrowAnyException();
    }

    @Test
    void 랜덤_숫자_생성_실패() {
        Integer start = 5;
        Integer end = -1;
        assertThatThrownBy(() -> RandomNumber.fromInteger(start,end))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void pickNumberInRange를_활용하여_범위_안에서_숫자_뽑기() {
        Integer start = 0;
        Integer end = 9;
        assertRandomNumberInRangeTest(() -> {
            RandomNumber randomNumber= RandomNumber.fromInteger(start,end);
            int pickNumber = randomNumber.pickNumber();
            assertThat(pickNumber).isBetween(start,end);
        },5);
    }


}
