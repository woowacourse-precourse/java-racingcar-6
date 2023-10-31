package racingcar.Model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import racingcar.Global.Constants;

class CarTest {

    static String name = "test";
    static Car car = new Car(name);

    @Test
    void 전진() {
        assertTrue(car.getCurrentLocation() == 0);
        car.goStraight(Constants.randomNumberCondition);
        assertTrue(car.getCurrentLocation() == 1);
    }

    @Test
    void 차_이름() {
        assertTrue(car.getCarName().equals(name));
    }

    @Test
    void 차_이름_유효성() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car("abcdef"))
                        .isInstanceOf(IllegalArgumentException.class));
    }
}