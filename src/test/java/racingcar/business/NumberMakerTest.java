package racingcar.business;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberMakerTest {

    @Test
    @DisplayName("만들어진 숫자가 0 ~ 9 사이에 존재하는 경우 ture를 반환한다.")
    void getRandomNumber_true() {
        // given
        NumberMaker numberMaker = new NumberMaker();

        // when
        boolean result = numberMaker.getRandomNumber() >= 0 || numberMaker.getRandomNumber() <= 9;

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("만들어진 숫자가 0 ~ 9 밖에 존재하는 경우 false를 반환한다.")
    void getRandomNumber_false() {
        // given
        NumberMaker numberMaker = new NumberMaker();

        // when
        boolean result = numberMaker.getRandomNumber() <= 0 || numberMaker.getRandomNumber() >= 9;

        // then
        assertThat(result).isFalse();
    }

}