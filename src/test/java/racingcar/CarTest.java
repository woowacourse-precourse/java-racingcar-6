package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

class CarTest {

    @Test
    @DisplayName("올바른 자동차 이름 생성 테스트")
    void createCarWithValidName() {
        Car car = new Car("car1");
        assertThat(car.getName()).isEqualTo("car1");
        assertThat(car.getDistance()).isZero();
    }

    @Test
    @DisplayName("잘못된 자동차 이름으로 생성할 때 예외 발생 테스트")
    void createCarWithInvalidName() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자이고 공백이 없으며 특수 기호를 포함할 수 없습니다.");

        assertThatThrownBy(() -> new Car("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자이고 공백이 없으며 특수 기호를 포함할 수 없습니다.");

        assertThatThrownBy(() -> new Car("car with space"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자이고 공백이 없으며 특수 기호를 포함할 수 없습니다.");

        assertThatThrownBy(() -> new Car("car#"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자이고 공백이 없으며 특수 기호를 포함할 수 없습니다.");

        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자이고 공백이 없으며 특수 기호를 포함할 수 없습니다.");

    }

    @Test
    @DisplayName("게임 참여 자동차 중복 테스트")
    void createCarsWithDuplicateNames() {
        assertThatThrownBy(() -> Car.createCars(Arrays.asList("car1", "car1")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void moveCar() {
        Car car = new Car("car1");
        int initialDistance = car.getDistance();

        car.move();

        assertThat(car.getDistance()).isGreaterThanOrEqualTo(initialDistance);
    }

    @Test
    @DisplayName("여러 자동차 생성 및 이동 테스트")
    void createAndMoveCars() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        List<Car> cars = Car.createCars(carNames);

        for (Car car : cars) {
            int initialDistance = car.getDistance();
            car.move();
            assertThat(car.getDistance()).isGreaterThanOrEqualTo(initialDistance);
        }
    }
}