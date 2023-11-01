package racingcar.business;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomNumberMakerTest {

    @Test
    @DisplayName("만들어진 숫자가 0 ~ 9 사이에 존재하는 경우 ture를 반환한다.")
    void getRandomNumber_true() {
        // given
        RandomNumberMaker numberMaker = new RandomNumberMaker();

        // when
        boolean result = numberMaker.getRandomNumber() >= 0 || numberMaker.getRandomNumber() <= 9;

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("만들어진 숫자가 0 ~ 9 밖에 존재하는 경우 false를 반환한다.")
    void getRandomNumber_false() {
        // given
        RandomNumberMaker numberMaker = new RandomNumberMaker();

        // when
        boolean result = numberMaker.getRandomNumber() <= 0 || numberMaker.getRandomNumber() >= 9;

        // then
        assertThat(result).isFalse();
    }

}