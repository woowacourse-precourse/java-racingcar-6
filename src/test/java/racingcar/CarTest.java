package racingcar;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class CarTest {

    @Test
    void getName_테스트() {
        final String testName = "povi";
        final Car car = new Car(testName);

        assertThat(car.getName()).contains(testName);
    }

    @Test
    void moving_테스트() {
        final int randomNumber = 6;
        final Car car = new Car();
        car.moving(randomNumber);

        assertThat(car.getDistance()).isEqualTo(1);
    }

}
