package racingcar.random;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.RandomNumber;

public class RandomNumberTest {

    @Test
    @DisplayName("자동차 이동 테스트")
    void carMoveTest() {
        // given
        Name name = Name.from("john");
        Car car = Car.from(name);
        RandomNumber randomNumber = new MovableRandomNumber();
        int number = randomNumber.pickNumber();

        // when
        car.accelerate(number);

        // then
        assertThat(car.isPositionEqualTo(1)).isTrue();
    }

    @Test
    @DisplayName("초과된 값이면 이동하지 않는다")
    void overValueNotMoveTest() {
        // given
        Name name = Name.from("john");
        Car car = Car.from(name);
        RandomNumber randomNumber = new HigherRandomNumber();
        int number = randomNumber.pickNumber();

        // when
        car.accelerate(number);

        // then
        assertThat(car.isPositionEqualTo(1)).isFalse();
    }

    @Test
    @DisplayName("기준점 이하면 이동하지 않는다")
    void underValueNotMoveTest() {
        // given
        Name name = Name.from("john");
        Car car = Car.from(name);
        RandomNumber randomNumber = new LowerRandomNumber();
        int number = randomNumber.pickNumber();

        // when
        car.accelerate(number);

        // then
        assertThat(car.isPositionEqualTo(1)).isFalse();
    }

    @Test
    @DisplayName("음수값이면 이동하지 않는다")
    void negativeValueNotMoveTest() {
        // given
        Name name = Name.from("john");
        Car car = Car.from(name);
        RandomNumber randomNumber = new MinusRandomNumber();
        int number = randomNumber.pickNumber();

        // when
        car.accelerate(number);

        // then
        assertThat(car.isPositionEqualTo(1)).isFalse();
    }
}
