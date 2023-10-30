package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest extends NsTest {

    private static final int STOP = 3;
    private static final int MOVING_FORWARD = 4;

    @Test
    void 자동차_이름이_중복되면_예외() {
        List<Car> cars = Arrays.asList(new Car("jhon"), new Car("abc"), new Car("jhon"));
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참가_자동차가_1대_이하면_예외() {
        List<Car> car = Arrays.asList(new Car("alone"));
        assertThatThrownBy(() -> new Cars(car))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 무작위_값이_3_이하면_멈추고_4_이상이면_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("jun, hoon", "2");
                    assertThat(output()).contains("jun : -", "hoon : --", "최종 우승자 : hoon");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}