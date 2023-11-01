package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void WinnersTest() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"), new Car("car4"), new Car("car5"));

        //car1 부터 car5까지 모두 전진시킨다.
        for (Car car : cars) {
            car.Move(4);
        }

        //모든 차량이 승자가 된다.
        List<String> winners = Application.Winners(cars);

        assertThat(winners).containsExactlyInAnyOrder("car1", "car2", "car3", "car4", "car5");

        //car1만 움직인다.
        cars.get(0).Move(4);

        winners = Application.Winners(cars);

        //car1만 승자가 된다.
        assertThat(winners).containsExactlyInAnyOrder("car1");

    }
}
