package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.global.message.ErrorMessage;
import org.junit.jupiter.api.Test;
import racingcar.view.InputValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 승자가_2대_이상(){

        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,java", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "java : -", "최종 우승자 : pobi, java");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void isInputValid_null_예외_발생(){
        String userInput = null;

        assertThatThrownBy(() -> InputValidator.isInputValid(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_IS_INVALID.getMessage());
    }

    @Test
    void isInputValid_빈_문자열_예외_발생(){
        String userInput = "";

        assertThatThrownBy(() -> InputValidator.isInputValid(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_IS_INVALID.getMessage());
    }

    @Test
    void isInputValid_공백_예외_발생(){
        String userInput = " ";

        assertThatThrownBy(() -> InputValidator.isInputValid(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_IS_INVALID.getMessage());
    }

    @Test
    void isInputDigit_숫자_이외_입력_예외_발생(){
        String userInput = "nonDigit";

        assertThatThrownBy(() -> InputValidator.isInputDigit(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }

    @Test
    void 빈_Car_이름_입력에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표만_있는_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표로_끝나는_입력에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_시도_횟수_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hello,world"," "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
