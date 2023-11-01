package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Error;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("GameService - setCarName")
    @Test
    void 유효한_자동차_이름() {
        // given
        List<String> carNames = Arrays.asList("rea", "mei", "jin");

        // when
        Car car = new Car(carNames);

        // then
        Assertions.assertThat(car.getCarName().containsAll(carNames));
    }

    @DisplayName("GameService - setCarName")

    @Test
    void 중복된_자동차_이름_예외_처리() {
        // given
        String carNames = "rea,mei,mei";

        // when
        assertThatCode(() -> runException(carNames))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.DUPLICATED_NAME);
    }

    @DisplayName("GameService - setCarName")
    @Test
    void 공백_입력_예외_처리() {
        // given
        String empty = "\n";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(empty))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Error.BLANK_INPUT)
        );
    }

    @DisplayName("GameService - setCarName")
    @Test
    void 쉼표로_구분하지_않고_공백으로_구분했을_경우() {
        // given
        String carNames = "hyun a day";

        // when
        assertThatThrownBy(() -> runException(carNames))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.NOT_ALLOW_SPACES);
    }

    @DisplayName("GameService - setTryNumber")
    @Test
    void 시도_횟수가_자연수() {
        //given
        String attemp = "1";

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
