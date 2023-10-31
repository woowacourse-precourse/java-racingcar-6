package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 자동차_생성자() {
        String carName = "pobi";
        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전진() {
        String carName = "pobi";
        Integer attempts = 10;
        Car car = new Car(carName);
        for(int i=1; i<=attempts; i++) {
            car.goForward();
            assertThat(car.getPosition()).isEqualTo(i);
        }

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
