package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;

class CarTest {

    @Test
    void 난수_값이_4이상이면_전진() {
        Car car = new Car("test");

        try (MockedStatic<Randoms> randoms = BDDMockito.mockStatic(Randoms.class)) {
            BDDMockito.given(Randoms.pickNumberInRange(0, 9)).willReturn(5);
            if (car.isMovingForward()) {
                car.moveForward();
            }
            Assertions.assertThat(car.getDistanceTraveled()).isEqualTo("-");
        }
    }

    @Test
    void 난수_값이_4미만이면_정지() {
        Car car = new Car("test");

        try (MockedStatic<Randoms> randoms = BDDMockito.mockStatic(Randoms.class)) {
            BDDMockito.given(Randoms.pickNumberInRange(0, 9)).willReturn(3);
            if (car.isMovingForward()) {
                car.moveForward();
            }
            Assertions.assertThat(car.getDistanceTraveled()).isEqualTo("");
        }
    }
}