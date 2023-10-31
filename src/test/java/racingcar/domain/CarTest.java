package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    static class 전진에_따른_올바른_출력 extends NsTest {

        @Test
        void 전진에_따른_올바른_출력값_확인() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run();
                        assertThat(output()).contains("pobi : ", "pobi : -", "pobi : -", "pobi : --");
                    },
                    MOVING_FORWARD, STOP, MOVING_FORWARD
            );
        }

        @Override
        protected void runMain() {
            Car car = new Car("pobi");

            System.out.println(car);

            car.isForward();
            System.out.println(car);

            car.isForward();
            System.out.println(car);

            car.isForward();
            System.out.println(car);
        }
    }

    static class 전진에_따른_올바른_전진_길이 extends NsTest {

        @Test
        void 전진에_따른_올바른_전진_길이_확인() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run();
                        assertThat(output()).contains("0", "1", "1", "2");
                    },
                    MOVING_FORWARD, STOP, MOVING_FORWARD
            );
        }

        @Override
        protected void runMain() {
            Car car = new Car("pobi");

            System.out.println(car.getForwardSize());

            car.isForward();
            System.out.println(car.getForwardSize());

            car.isForward();
            System.out.println(car.getForwardSize());

            car.isForward();
            System.out.println(car.getForwardSize());
        }
    }
}