package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("이름이 5글자 이상일 경우 예외가 발생한다.")
    void evaluate() {
        assertThatThrownBy(() -> new Car("woowacourse"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
