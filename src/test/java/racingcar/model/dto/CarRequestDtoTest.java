package racingcar.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class CarRequestDtoTest {
    @Test
    @DisplayName("CarRequestDto 생성자를 테스트 합니다.")
    void CarRequestDto_생성자_확인() {
        String carName = "pobi,woni,jun";
        CarRequestDto carRequestDto = new CarRequestDto(carName);

        assertThat(carRequestDto).isNotNull();
        assertThat(carRequestDto.getCarNames()).isEqualTo(Arrays.asList("pobi", "woni", "jun"));
    }

    @Test
    @DisplayName("Car 객체 생성을 테스트 합니다.")
    void Car_객체_생성() {
        String carName = "pobi,woni,jun";
        CarRequestDto carRequestDto = new CarRequestDto(carName);

        List<Car> cars = carRequestDto.toCar();

        assertThat(cars).isNotNull();
        assertThat(3).isEqualTo(cars.size());
        assertThat("pobi").isEqualTo(cars.get(0).getName());
        assertThat("woni").isEqualTo(cars.get(1).getName());
        assertThat("jun").isEqualTo(cars.get(2).getName());
    }
}