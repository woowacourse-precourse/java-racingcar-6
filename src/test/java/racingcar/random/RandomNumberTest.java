package racingcar.random;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.RandomNumber;

public class RandomNumberTest {

    @Test
    void 자동차_이동_테스트() {
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
    void 초과된_값이면_이동하지_않는다() {
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
    void 기준점_이하면_이동하지_않는다() {
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
    void 음수값이면_이동하지_않는다() {
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
