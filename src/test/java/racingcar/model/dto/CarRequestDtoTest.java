package racingcar.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class CarRequestDtoTest {
    private CarRequestDto carRequestDto;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        String carNames = "pobi,woni";
        carRequestDto = new CarRequestDto(carNames);
        cars = carRequestDto.toCar();
    }

    @Test
    @DisplayName("CarRequestDto 생성자를 테스트 합니다.")
    void CarRequestDto_생성자_확인() {
        assertThat(carRequestDto).isNotNull();
        assertThat(carRequestDto).extracting(CarRequestDto::getCarNames).isEqualTo(Arrays.asList("pobi", "woni"));
    }

    @Test
    @DisplayName("Car 객체 생성을 테스트 합니다.")
    void Car_객체_생성() {
        assertThat(cars).isNotNull();
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars).extracting(Car::getName).containsExactly("pobi", "woni");
    }
}