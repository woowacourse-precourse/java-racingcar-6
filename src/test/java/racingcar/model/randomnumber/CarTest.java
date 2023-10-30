package racingcar.model.randomnumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Name;

public class CarTest {

    @Test
    @DisplayName("4 미만의 수가 주어질 시 이동되지 않는다.")
    void notMoveTest() {
        // given
        Name name = Name.from("john");
        Car car = Car.createDefault(name);
        RandomNumber randomNumber = new LowerNumber();

        // when
        car.move(randomNumber.pickNumber());

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
