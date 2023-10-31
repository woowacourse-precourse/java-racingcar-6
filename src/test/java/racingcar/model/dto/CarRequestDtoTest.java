package racingcar.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class CarRequestDtoTest {
    private final String carName1 = "pobi";
    private final String carName2 = "woni";
    private final String carNames = String.join(",", carName1, carName2);
    private CarRequestDto carRequestDto;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        carRequestDto = new CarRequestDto(carNames);
        cars = carRequestDto.toCar();
    }

    @Test
    @DisplayName("CarRequestDto 생성자를 테스트 합니다.")
    void CarRequestDto_생성자_확인() {
        assertThat(carRequestDto).isNotNull();
        assertThat(carRequestDto.getCarNames()).containsExactly(carName1, carName2);
    }

    @Test
    @DisplayName("Car 객체 생성을 테스트 합니다.")
    void Car_객체_생성() {
        assertThat(cars).isNotNull();
        assertThat(cars).hasSize(2);
        assertThat(cars).extracting(Car::getName).containsExactly(carName1, carName2);
    }
}