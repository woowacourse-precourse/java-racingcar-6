package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;

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

//    @ParameterizedTest
//    @ValueSource(strings = {
//            "pobi,etion,,hyo", ",etion,jay,gogi", "hyo, ,Uto,victus", // 1. 이름 입력 시 공백 예외 처리
//            "pobi,hyo,mk,jay,hyo",                                    // 2. 이름 중복 시 예외 처리
//            "pobi,javaji"                                             // 3. 이름 길이 예외처리
//    })
    @Test
    void 이름에_대한_예외_처리(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_입력_시_정수_이외의_값_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jay", "1.8"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
