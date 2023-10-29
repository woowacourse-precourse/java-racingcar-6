package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCar;
import racingcar.utils.RacingCarGameInput;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void validateCarNames_메소드를_사용시_자동차_이름이_5자가_넘어가는_경우_예외_발생() {
        List<RacingCar> carList = List.of(
            new RacingCar("exception")
        );
        assertThatThrownBy(() -> RacingCarGameInput.validateCarNames(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_BIGGER_THAN_5CHAR);
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
