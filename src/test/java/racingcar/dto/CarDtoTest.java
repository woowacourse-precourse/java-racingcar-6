package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarDtoTest {
    @Test
    void 주어진_Car을_통해_DTO_객체를_생성한다() {
        Car car = Car.from("melon");
        CarDto carDto = CarDto.from(car);

        assertThat(carDto.name()).isEqualTo("melon");
        assertThat(carDto.position()).isEqualTo(0);
    }
}
