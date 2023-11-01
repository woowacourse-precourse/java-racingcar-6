package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.Utils;

import java.util.ArrayList;
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

    @Test
    void 쉼표_구분_문자열_리스트_반환() {
        List<String> split = Utils.split("안녕,하이,반갑");
        assertThat(split).isEqualTo(Arrays.asList("안녕", "하이", "반갑"));
    }

    @Test
    void 게임횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,kdj", "ggal"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 경계값_입력시_점수반영_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,kdj", "1");
                    assertThat(output()).contains("pobi : ", "woni : -", "kdj : -", "최종 우승자 : woni, kdj");
                },
                0, 4, 4
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
