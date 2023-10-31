package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class NumericUtilityTest {

    @Test
    @DisplayName("숫자가 4 이상이라면 true로 반환")
    void convertNumberIfGreaterOrEqualToFourTest1() {
        int number1 = 4;
        int number2 = 9;
        boolean actual1 = NumericUtility.isNumberGreaterOrEqualToFour(number1);
        boolean actual2 = NumericUtility.isNumberGreaterOrEqualToFour(number2);

        assertThat(actual1).isEqualTo(true);
        assertThat(actual2).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자가 4 미만이라면 false으로 반환")
    void convertNumberIfGreaterOrEqualToFourTest2() {
        int number1 = 0;
        int number2 = 3;
        boolean actual1 = NumericUtility.isNumberGreaterOrEqualToFour(number1);
        boolean actual2 = NumericUtility.isNumberGreaterOrEqualToFour(number2);

        assertThat(actual1).isEqualTo(false);
        assertThat(actual2).isEqualTo(false);
    }

    @Test
    @DisplayName("차량 이동 횟수 중에 가장 큰 값을 반환")
    void findMaxPositionTest1() {
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"), new Car("honux"));
        cars.get(0).move(1);
        cars.get(0).move(1);
        cars.get(0).move(1);
        cars.get(1).move(1);
        cars.get(2).move(1);
        cars.get(2).move(1);
        int maxPosition = NumericUtility.findMaxPosition(cars);
        assertThat(maxPosition).isEqualTo(3);
    }
}