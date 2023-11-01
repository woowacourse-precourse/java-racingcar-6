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
    void 종합_3대_5회_단독우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,inss,R8", "5");
                    assertThat(output()).contains(
                            "pobi : -", "inss : ", "R8 : -",
                            "pobi : --", "inss : -", "R8 : --",
                            "pobi : ---", "inss : -", "R8 : ---",
                            "pobi : ----", "inss : --", "R8 : ----",
                            "pobi : -----", "inss : --", "R8 : ----",
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 종합_4대_10회_공동우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,inss,R8,pepsi", "10");
                    assertThat(output()).contains(
                            "pobi : -", "inss : ", "R8 : -", "pepsi : -",
                            "pobi : --", "inss : -", "R8 : --", "pepsi : --",
                            "pobi : ---", "inss : -", "R8 : ---", "pepsi : ---",
                            "pobi : ----", "inss : --", "R8 : ----", "pepsi : ----",
                            "pobi : -----", "inss : --", "R8 : -----", "pepsi : ----",
                            "pobi : ------", "inss : --", "R8 : ------", "pepsi : -----",
                            "pobi : -------", "inss : ---", "R8 : -------", "pepsi : ------",
                            "pobi : --------", "inss : ---", "R8 : -------", "pepsi : -------",
                            "pobi : ---------", "inss : ----", "R8 : ---------", "pepsi : --------",
                            "pobi : ----------", "inss : ----", "R8 : ----------", "pepsi : ---------",
                            "최종 우승자 : pobi, R8, pepsi"
                            );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
