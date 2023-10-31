package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarDtoTest {

    @DisplayName("CarDto를 Car로 생성할 수 있다.")
    @Test
    void from() {
        // given
        Car car = Car.from("aaa");

        // when
        CarDto carDto = CarDto.from(car);

        // then
        assertThat(carDto.name()).isEqualTo("aaa");
        assertThat(carDto.position()).isEqualTo(0);
    }
}