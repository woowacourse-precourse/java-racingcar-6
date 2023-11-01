package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_생성() {
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");
        List<Car> cars = new ArrayList<>();
        for (String carName: carNames) {
            cars.add(new Car(carName));
        }
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(0).getStep()).isEqualTo(0);
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(1).getStep()).isEqualTo(0);
        assertThat(cars.get(2).getName()).isEqualTo("car3");
        assertThat(cars.get(2).getStep()).isEqualTo(0);
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
