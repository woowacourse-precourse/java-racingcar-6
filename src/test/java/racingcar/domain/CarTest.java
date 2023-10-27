package racingcar.domain;

import domain.Car;
import domain.Cars;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 이름 길이가 5보다 클 경우")
    void car_name_length_check() {
        Assertions.assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백인 경우")
    void car_name_blank_check() {
        Assertions.assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복인 경우")
    void car_name_duplicate_check() {
        Assertions.assertThatThrownBy(() -> new Cars("ab,cd,ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
