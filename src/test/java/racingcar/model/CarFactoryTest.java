package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarFactoryTest {

    @DisplayName("자동차 이름 목록을 전달하면, 목록 길이만큼의 자동차 객체를 생성한다.")
    @Test
    void Given_CarNames_When_InitCars_Then_Cars() throws Exception {
        // Given
        List<String> carNames = List.of("edgar", "elmo", "kue");

        // When
        List<Car> cars = CarFactory.initCars(carNames);

        // Then
        assertThat(cars).hasSize(carNames.size());
    }
}
