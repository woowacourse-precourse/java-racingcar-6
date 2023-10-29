package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    public static final int MOVING_FORWARD = 4;
    public static final int STOP = 3;

    @Test
    public void 생성자_이름_조회_테스트() throws Exception {
        String expected = "david";
        Car car = new Car(expected);

        Assertions.assertThat(car.getName()).isEqualTo(expected);
    }

    @Nested
    class proceed_메서드는 {
        @Test
        public void 삼이하의_숫자에_전진하지_않는다() throws Exception {
            int round = 6;
            int expected = 0;

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        Car car = new Car("david");
                        for (int i = 0; i < round; i++) {
                            car.proceed();
                        }
                        Assertions.assertThat(car.getDistance()).isEqualTo(expected);
                    },
                    STOP,
                    STOP, 2, 1, 0
            );
        }

        @Test
        public void 사이상의_숫자에_전진한다() throws Exception {
            int round = 8;
            int expected = 8;

            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        Car car = new Car("david");
                        for (int i = 0; i < round; i++) {
                            car.proceed();
                        }
                        Assertions.assertThat(car.getDistance()).isEqualTo(expected);
                    },
                    MOVING_FORWARD,
                    MOVING_FORWARD, 5, 6, 7, 8, 9
            );
        }
    }

}