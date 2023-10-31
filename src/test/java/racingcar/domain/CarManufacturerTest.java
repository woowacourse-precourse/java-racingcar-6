package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarManufacturerTest {
    private CarManufacturer carManufacturer;

    @BeforeEach
    void init() {
        carManufacturer = new CarManufacturer();
    }

    @Test
    @DisplayName("정상적인 이름이 주어질 때, Car 리스트 반환")
    void 자동차_정상생성() {
        Assertions.assertThat(carManufacturer.createCars(List.of("fobi", "zoon", "zo")))
                .contains(new Car("fobi"),
                        new Car("zoon"),
                        new Car("zo"));
    }

    @Test
    @DisplayName("이름이 5글자가 넘어서면, 예외 발생")
    void 자동차_이름길이_초과_예외발생() {

        assertThatThrownBy(() ->
                carManufacturer.createCars(List.of("zozood", "zozo", "fobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}