package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @ParameterizedTest
    @CsvSource({"0,1,2,0", "3,4,5,2", "9,4,5,3", "2,3,7,1"})
    public void 자동차_전진(int number1, int number2, int number3, int expected) {
        car.judgeNumberToGo(number1);
        car.judgeNumberToGo(number2);
        car.judgeNumberToGo(number3);

        int actual = car.getDistance();
        assertThat(actual).isEqualTo(expected);
    }
}