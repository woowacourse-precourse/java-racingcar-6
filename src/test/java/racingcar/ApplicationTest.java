package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import car.Car;
import org.junit.jupiter.api.Test;

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

    @Test
    public void 빈_자동차_이름_검증() {
        List<Car> cars = List.of(new Car("Car1"), new Car("Car2"), new Car("Car3"));

        assertThatThrownBy(() -> Application.validateCarName("", cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 자동차 이름입니다.");
    }

    @Test
    public void 자동차_이름_5자_이상_검증() {
        List<Car> cars = List.of(new Car("Car1"), new Car("Car2"), new Car("Car3"));

        assertThatThrownBy(() -> Application.validateCarName("InvalidCarName", cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자 이상입니다.");
    }

    @Test
    public void 중복된_자동차_이름_검증() {
        List<Car> cars = List.of(new Car("Car1"), new Car("Car2"), new Car("Car3"));

        assertThatThrownBy(() -> Application.validateCarName("Car1", cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름이 존재합니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
