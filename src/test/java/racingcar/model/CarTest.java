package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 생성")
    void of() {
        Car car = Car.of("pobi");

        assertThat(car).isEqualTo(Car.of("pobi"));
    }

    @ParameterizedTest
    @CsvSource({"4", "9"})
    @DisplayName("자동차 이동 - 4 이상")
    void move(int randomNumber) {
        Car car = Car.of("pobi");
        car = car.move(() -> randomNumber);

        assertThat(car).isEqualTo(Car.ofWithPosition("pobi", 1));
    }

    @ParameterizedTest
    @CsvSource({"3", "0"})
    @DisplayName("자동차 이동 - 3 이하")
    void moveFail(int randomNumber) {
        Car car = Car.of("pobi");
        car = car.move(() -> randomNumber);

        assertThat(car).isEqualTo(Car.ofWithPosition("pobi", 0));
    }

    @Test
    @DisplayName("position값과 같을 시 위너로 판단하여 true를 반환한다.")
    void isWinner() {
        Car car = Car.ofWithPosition("pobi", 3);
        Position position = Position.of(3);

        assertThat(car.isWinner(position)).isTrue();
    }

    @Test
    @DisplayName("position값과 다를 시 위너로 판단하여 false를 반환한다.")
    void isWinnerFail() {
        Car car = Car.ofWithPosition("pobi", 3);
        Position position = Position.of(2);

        assertThat(car.isWinner(position)).isFalse();
    }

    @Test
    @DisplayName("자동차의 이름을 반환한다.")
    void getName() {
        Car car = Car.ofWithPosition("pobi", 3);

        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차의 위치를 반환한다.")
    void getPosition() {
        Car car = Car.ofWithPosition("pobi", 3);

        assertThat(car.getPosition()).isEqualTo(Position.of(3));
    }

    @Test
    @DisplayName("자동차의 이름과 위치를 반환한다.")
    void toStringTest() {
        Car car = Car.ofWithPosition("pobi", 3);

        assertThat(car.toString()).isEqualTo("pobi : ---");
    }
}