package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.racing.CarManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarManagerTest {

    @Test
    @DisplayName("입력된 자동차 이름을 기반으로 Car 객체 리스트를 생성한다.")
    void createCars_ValidInput_CreatesCarList() {
        // Given
        String carNames = "car1,car2,car3";

        // When
        CarManager carManager = new CarManager(carNames);
        List<Car> cars = carManager.getCars();

        // Then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }

    @Test
    @DisplayName("입력된 자동차 이름 중에 길이가 5자를 초과하는 이름이 있으면 예외를 던진다.")
    void createCars_NameLengthGreaterThanFive_ThrowsException() {
        // Given
        String carNames = "car1,tooLongName,car3";

        // When & Then
        assertThatThrownBy(() -> new CarManager(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("0에서 9 사이의 무작위 값이 4 이상일 경우 자동차가 전진한다.")
    void move_RandomNumberGreaterThanOrEqualFour_CarMoves() {
        // Given
        Car car = new Car("car");

        // When
        car.move(() -> 4);
        car.move(() -> 8);

        // Then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("0에서 9 사이의 무작위 값이 4 미만일 경우 자동차가 전진하지 않는다.")
    void move_RandomNumberLessThanFour_CarDoesNotMove() {
        // Given
        Car car = new Car("car");

        // When
        car.move(() -> 3);
        car.move(() -> 1);

        // Then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
