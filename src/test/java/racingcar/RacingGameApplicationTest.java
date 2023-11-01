package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.global.enums.Constant.FORWARD_THRESHOLD;
import static racingcar.global.enums.ExceptionMessage.DUPLICATE_NAME_MESSAGE;
import static racingcar.global.enums.ExceptionMessage.EXCEED_MAX_LENGTH_MESSAGE;
import static racingcar.global.enums.ExceptionMessage.NAME_HAS_WHITE_SPACE_MESSAGE;
import static racingcar.global.enums.ExceptionMessage.NON_NUMERIC_INPUT_ERROR_MESSAGE;
import static racingcar.global.enums.ExceptionMessage.NULL_OR_EMPTY_INPUT_MESSAGE;
import static racingcar.global.enums.ExceptionMessage.TRIAL_MINIMUM_MESSAGE;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RacingGameApplicationTest extends NsTest {

    @Test
    void 입력_빈_문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", ""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NULL_OR_EMPTY_INPUT_MESSAGE.getMessage()));
    }

    @Test
    void 시행_횟수_문자_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NON_NUMERIC_INPUT_ERROR_MESSAGE.getMessage()));
    }

    @Test
    void 시행_횟수_자연수_아닌_경우_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(TRIAL_MINIMUM_MESSAGE.getMessage()));

    }

    @Test
    void 이름_공백_포함_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a, b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NAME_HAS_WHITE_SPACE_MESSAGE.getMessage()));
    }

    @Test
    void 이름_길이_초과_예외() {
        //given
        String name = TestUtils.generateNameExceedingMaxLength();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(name + ",b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(EXCEED_MAX_LENGTH_MESSAGE.getMessage()));
    }

    @Test
    void 이름_중복_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,a", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(DUPLICATE_NAME_MESSAGE.getMessage()));
    }

    @Test
    void 단일_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b", "1");
                    assertThat(output()).contains("실행 결과", "a : -", "b : ", "최종 우승자 : a");
                },
                FORWARD_THRESHOLD.getConstant(), FORWARD_THRESHOLD.getConstant() - 1
        );
    }

    @Test
    void 공동_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b", "2");
                    assertThat(output()).contains("실행 결과", "a : -", "b : -",
                            "a : --", "b : --", "최종 우승자 : a, b");
                },
                FORWARD_THRESHOLD.getConstant(), FORWARD_THRESHOLD.getConstant()
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
