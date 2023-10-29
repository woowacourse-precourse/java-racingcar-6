package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;;

import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void createRandomNumber_메서드로_랜덤_값을_반환() {
        int result = Utils.createRandomNumber();

        assertThat(Utils.isNumberRange(result)).isTrue();
    }
}