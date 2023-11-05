package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CarTest extends NsTest {

    @Test
    void 자동차_이름_확인() {
        Car car = new Car("a");
        assertThat(car.getName()).isEqualTo("a");
    }

    @Test
    void 자동차_이동_확인() {
        Car car = new Car("a");
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(5);
        car.move(26);
        assertThat(car.getPosition()).isEqualTo(31);
    }

    @Override
    protected void runMain() {

    }
}
