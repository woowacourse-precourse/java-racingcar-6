package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarDtoTest {

    @Test
    @DisplayName("CarDto 생성")
    void 생성() {
        // given
        Car car = Car.from("aaa");

        // when
        CarDto carDto = CarDto.from(car);

        // then
        assertThat(carDto.name()).isEqualTo("aaa");
        assertThat(carDto.position()).isEqualTo(0);
    }
}