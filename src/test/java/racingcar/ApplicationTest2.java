package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ApplicationTest2 extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @RepeatedTest(value = 10, name = "{displayName} 중 {currentRepetition} of {totalRepetitions}")
    void 전진_정지_2번() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,judy", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "judy : -", "최종 우승자 : pobi, woni, judy");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_공백포함_시_정상_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("     pobi , woni  ", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 중복_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_개수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"'pobi,woni,'", "',pobi,woni'", "'pobi,,woni'"})
    void 쉼표에_대한_예외_처리(String carNameInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNameInput, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
