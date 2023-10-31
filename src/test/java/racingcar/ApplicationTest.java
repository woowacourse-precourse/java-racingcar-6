package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.InputError.BLANK_CAR_NAME;
import static racingcar.constant.InputError.EXCEEDED_LIMIT_CAR_LENGTH;
import static racingcar.constant.InputError.EXCEEDED_MAXIMUM_INPUT;
import static racingcar.constant.InputError.NOT_DIGIT_MOVING_COUNT;
import static racingcar.constant.StepConstant.MOVING_FORWARD;
import static racingcar.constant.StepConstant.STOP;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @DisplayName("자동차 경주를 진행한다.")
    @Test
    void 전진_정지_단일_이동횟수() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("자동차 경주를 진행할 때 공동 우승자가 있을 수 있다.")
    @Test
    void 전진_정지_복수_이동횟수() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : --", "woni : ", "jun : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP
        );
    }

    @DisplayName("자동차 경주를 진행할 때 이름의 길이 제한을 지켜야한다.")
    @Test
    void 이름에_대한_예외_처리_제한길이_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(EXCEEDED_LIMIT_CAR_LENGTH.toString())
        );
    }

    @DisplayName("자동차 경주를 진행할 때 자동차 이름의 공백을 포함하여도 길이 제한을 지켜야한다.")
    @Test
    void 이름에_대한_예외_처리_제한길이_초과_공백문자열_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("    po,jin", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(EXCEEDED_LIMIT_CAR_LENGTH.toString())
        );
    }

    @DisplayName("자동차 경주를 진행할 때 자동차 이름 입력은 필수이다.")
    @Test
    void 이름에_대한_예외_처리_빈값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",javi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(BLANK_CAR_NAME.toString())
        );
    }

    @DisplayName("자동차 경주를 진행할 때 자동차 이름은 공백일 수 없다.")
    @Test
    void 이름에_대한_예외_처리_빈값_여러개() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("    ,javi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(BLANK_CAR_NAME.toString())
        );
    }

    @DisplayName("자동차 경주를 진행할 때 이동 횟수는 숫자여야한다.")
    @Test
    void 이동_횟수에_대한_예외_처리_숫자가_아닌_값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "1ab3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NOT_DIGIT_MOVING_COUNT.toString())
        );
    }

    @DisplayName("자동차 경주를 진행할 때 이동 횟수는 제한 크기를 넘으면 안된다.")
    @Test
    void 이동_횟수에_대한_예외_처리_너무_큰_값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "99999999999"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(EXCEEDED_MAXIMUM_INPUT.toString())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
