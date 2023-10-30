package racingcar.domain;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.domain.racing.RandomMoveStrategy.MIN_NUM;

class CarManagerTest {
    @Test
    @DisplayName("자동차 이름을 파싱하면 Car 객체의 리스트를 반환한다")
    void parseCarNames_ReturnsListOfCars() {
        // Given
        CarManager carManager = new CarManager();

        // When
        carManager.parseCarNames("car1,car2,car3");

        // Then
        assertThat(carManager.getCars()).hasSize(3)
                .extracting("name")
                .containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외를 던진다")
    void parseCarNames_WithDuplicateNames_ThrowsException() {
        // Given
        CarManager carManager = new CarManager();

        // When
        Executable executable = () -> carManager.parseCarNames("car1,car2,car1");

        // Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, executable);
        assertThat(thrown).hasMessageContaining("중복된 자동차 이름이 있습니다");
    }

    @Test
    @DisplayName("0에서 9 사이의 무작위 값이 4 이상일 경우 자동차가 전진한다.")
    void move_RandomNumberGreaterThanOrEqualFour_CarMoves() {
        // Given
        Car car = new Car("car",()-> 5 >= MIN_NUM);

        // When
        car.move();

        // Then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("0에서 9 사이의 무작위 값이 4 미만일 경우 자동차가 전진하지 않는다.")
    void move_RandomNumberLessThanFour_CarDoesNotMove() {
        // Given
        Car car = new Car("car",()-> 3 >= MIN_NUM);

        // When
        car.move();

        // Then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
