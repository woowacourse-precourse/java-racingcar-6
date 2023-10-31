package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.randomnumber.LowerNumber;
import racingcar.model.randomnumber.MovableNumber;
import racingcar.model.randomnumber.RandomNumber;

public class CarTest {

    @Nested
    @DisplayName("자동차 이동 테스트")
    class CarMoveTest {

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

        @Test
        @DisplayName("4 이상의 값이 주어질 시 이동된다.")
        void moveTest() {
            // given
            Name name = Name.from("john");
            Car car = Car.createDefault(name);
            RandomNumber randomNumber = new MovableNumber();

            // when
            car.move(randomNumber.pickNumber());

            // then
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }
}
