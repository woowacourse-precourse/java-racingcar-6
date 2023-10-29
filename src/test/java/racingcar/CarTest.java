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

    @Nested
    class compareTo_메서드는 {
        static Car car1 = new Car("alpha");
        static Car car2 = new Car("bravo");
        static Car car3 = new Car("char");
        static int round = 3;

        @Nested
        class distance가 {
            @Test
            public void 큰_메서드를_인자로_받으면_양수를_리턴한다() throws Exception {

                camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                        () -> {
                            for (int i = 0; i < round; i++) {
                                car1.proceed();
                                car2.proceed();
                                car3.proceed();
                            }
                            Assertions.assertThat(car1.compareTo(car2) > 0).isTrue();
                        },
                        STOP,
                        MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
                );
            }

            @Test
            public void 같은_메서드를_인자로_받으면_0을_리턴한다() throws Exception {

                camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                        () -> {
                            for (int i = 0; i < round; i++) {
                                car1.proceed();
                                car2.proceed();
                                car3.proceed();
                            }
                            Assertions.assertThat(car2.compareTo(car3) == 0).isTrue();
                        },
                        STOP,
                        MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
                );
            }

            @Test
            public void 작은_메서드를_인자로_받으면_음수를_리턴한다() throws Exception {

                camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                        () -> {
                            for (int i = 0; i < round; i++) {
                                car1.proceed();
                                car2.proceed();
                                car3.proceed();
                            }
                            Assertions.assertThat(car2.compareTo(car1) < 0).isTrue();
                        },
                        STOP,
                        MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
                );
            }
        }
    }

}