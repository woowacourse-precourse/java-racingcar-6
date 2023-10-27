package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차의 이름이 5글자 이상이면 에러가 발생합니다.")
    public void CarNameTest() {
        Assertions.assertThatThrownBy(() -> new Car("abcde"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}