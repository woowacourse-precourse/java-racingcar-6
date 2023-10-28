package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarFactoryTest {

    @DisplayName("자동차들의 이름을 넘기면, 각각의 이름을 가진 Car 객체를 생성한다.")
    @Test
    void Given_CarNames_When_InitCars_Then_Cars() throws Exception {
        // Given
        List<String> carNames = List.of("edgar", "elmo", "kue");

        // When
        List<Car> cars = CarFactory.initCars(carNames);
        String firstCarName = cars.get(0).getName();

        // Then
        assertThat(firstCarName).isEqualTo(carNames.get(0));
    }

    @DisplayName("공백의 자동차 이름을 넘기면, 예외가 발생한다.")
    @Test
    void Given_EmptyCarName_When_InitCars_Then_ThrowException() throws Exception {
        // Given
        List<String> carNames = List.of("", "elmo", "kermit");

        // When & Then
        assertThatThrownBy(() -> CarFactory.initCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 자동차 이름입니다.");
    }

    @DisplayName("최대 유효 길이를 초과하는 자동차 이름을 넘기면, 예외가 발생한다.")
    @Test
    void Given_SoLongCarName_When_InitCars_Then_ThrowException() throws Exception {
        // Given
        List<String> carNames = List.of("soLongLongName", "elmo", "kermit");

        // When & Then
        assertThatThrownBy(() -> CarFactory.initCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 자동차 이름입니다.");
    }
}
