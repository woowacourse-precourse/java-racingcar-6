package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.method.RacingCar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jade,sugar", "-1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 전진_횟수_비교() {
        ArrayList<Car> car_list = new ArrayList<>();
        RacingCar racingCar = new RacingCar();
        Car test_car_1 = new Car("tom");
        Car test_car_2 = new Car("brown");
        test_car_1.setMove_count(4);
        test_car_2.setMove_count(3);
        car_list.add(test_car_1);
        car_list.add(test_car_2);

        assertThat(racingCar.compareMoveCount(car_list)).isEqualTo(4);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
