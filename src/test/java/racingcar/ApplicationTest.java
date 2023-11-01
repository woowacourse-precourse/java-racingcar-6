package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("[자동차 이름] 배열 구분")
    @Test
    void splitToArrayTest() {
        String carNameString = "carA,carB,carC,carD,carE";
        String[] result = InputHandler.splitToArray(carNameString);
        String[] answer = {"carA", "carB", "carC", "carD", "carE"};

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("[자동차 이름] 예외 발생 - 입력값 부재")
    @Test
    void carNameExceptionTest1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("[자동차 이름] 예외 발생 - 공백 포함")
    @Test
    void carNameExceptionTest2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("carA,carB,car C,carD,carE", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("[자동차 이름] 예외 발생 - 쉼표(,) 2개이상 연속")
    @Test
    void carNameExceptionTest3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("carA,,carB,carC,carD,carE", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("[자동차 이름] 예외 발생 - 쉼표(,) 맨 앞/뒤 위치")
    @Test
    void carNameExceptionTest4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",carA,carB,carC,carD,carE", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("[자동차 이름] 예외 발생 - 길이 제한 초과")
    @Test
    void carNameExceptionTest5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("carA,carB,carC,carD,mycarE", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("[자동차 이름] 예외 발생 - 중복 입력")
    @Test
    void carNameExceptionTest6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("carA,carB,carC,carD,carE,carB", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
