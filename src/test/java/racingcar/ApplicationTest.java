package racingcar;

import action.Car;
import action.CarGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_생성_주행_테스트() {
        CarGenerator generator = new CarGenerator("car1,car2");
        List<Car> carList = generator.makeCars();

        for (Car car : carList) {
            int pickNumber = Randoms.pickNumberInRange(0, 9);

            if (pickNumber >= MOVING_FORWARD) {
                car.moveForward();
                assertThat(car.getStatus()).isEqualTo("-");
            } else {
                assertThat(car.getStatus()).isEqualTo("");
            }
        }
    }

    @Test
    void 자동차_이름_길이_예외_처리() {
        CarGenerator generator = new CarGenerator("apple,applePie");
        assertThatThrownBy(() -> generator.makeCars())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주행_테스트() {
        Car car = new Car("test");
        int pickNumber = Randoms.pickNumberInRange(0, 9);

        if (pickNumber >= MOVING_FORWARD) {
            car.moveForward();
            assertThat(car.getStatus()).isEqualTo("-");
        } else {
            assertThat(car.getStatus()).isEqualTo("");
        }
    }

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
}
