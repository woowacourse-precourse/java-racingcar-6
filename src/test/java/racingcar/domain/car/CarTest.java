package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CarTest extends NsTest {

    @Test
    void 차_이름을_가져오는지_Test() {
        Car car = new Car("뛰뛰빵빵");
        assertThat(car.getName()).isEqualTo("뛰뛰빵빵");
    }

    @Test
    void 거리가_기본적으로_0인지_Test() {
        Car car = new Car("뛰뛰빵빵");
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 차가_움직인_후에_거리가_증가하는지_확인() {
        Car car = new Car("뛰뛰빵빵");
        car.moveCar();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Override
    protected void runMain() {
        Car car = new Car("메인");
        car.moveCar();
    }
}
