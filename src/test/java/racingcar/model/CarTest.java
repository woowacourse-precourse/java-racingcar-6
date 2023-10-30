package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void go_메서드는_position_을_증가시킨다() {
        Car car = new Car("자동차");
        car.go(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"true, false, 1", "false, true, -1", "true, true, 0"})
    void comparePosition_메서드는_자신과_다른_자동차_객체를_비교해_position_의_대소관계를_비교한다(boolean myCarMove, boolean compareCarMove, int result) {
        Car myCar = new Car("내자동차");
        Car compareCar = new Car("상대자동차");
        myCar.go(myCarMove);
        compareCar.go(compareCarMove);
        assertThat(myCar.comparePosition(compareCar)).isEqualTo(result);
    }

    @Test
    void equals_메서드는_다른_Car_객체와_position_이_같은지_판별한다() {
        Car car = new Car("내자동차");
        Car compareCar = new Car("상대자동차");
        assertThat(car.equals(compareCar)).isTrue();
    }


}
