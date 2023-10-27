package racingcar.random;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.GameRandomNumber;
import racingcar.model.Name;
import racingcar.model.RandomNumber;

public class RandomNumberTest {

    @Test
    void 자동차_이동_테스트() {
        // given
        Name name = Name.from("john");
        Car car = Car.from(name);
        RandomNumber randomNumber = new GameRandomNumber();
        int number = randomNumber.pickNumber();
        // when
        car.accelerate(number);
        // then
        assertThat(car.isPositionEqualTo(1)).isTrue();
    }
}
