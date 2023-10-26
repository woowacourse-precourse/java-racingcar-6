package racingcar.domain;

import domain.Car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 이름에 아무것도 없는 경우")
    void null_check() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(null));
    }

    @Test
    @DisplayName("자동차 이름 길이가 5보다 클 경우")
    void car_name_length_check() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("abcdefg"));
    }
}
