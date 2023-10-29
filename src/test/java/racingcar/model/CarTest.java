package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "1, 0"})
    void go_메서드는_입력값이_4보다_크면_position_을_1_증가시킨다(Integer goValue, Integer result) {
        Car car = new Car("자동차");
        car.go(goValue);
        assertThat(car.getPosition()).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("provideCarTestArgument")
    void comparePosition_메서드는_자신과_다른_자동차_객체를_비교해_position_의_대소관계를_비교한다(Integer myMove, Integer compareMove, Integer result) {
        Car myCar = new Car("내자동차");
        Car compareCar = new Car("상대자동차");
        myCar.go(myMove);
        compareCar.go(compareMove);
        assertThat(myCar.comparePosition(compareCar)).isEqualTo(result);
    }

    @Test
    void equals_메서드는_다른_Car_객체와_position_이_같은지_판별한다() {
        Car car = new Car("내자동차");
        Car compareCar = new Car("상대자동차");
        assertThat(car.equals(compareCar)).isTrue();
    }

    static List<Arguments> provideCarTestArgument() {
        return Arrays.asList(
                Arguments.of(4, 0, 1),
                Arguments.of(0, 4, -1),
                Arguments.of(4, 4, 0)
        );
    }
}
