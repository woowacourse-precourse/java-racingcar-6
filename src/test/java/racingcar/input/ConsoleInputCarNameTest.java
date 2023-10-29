package racingcar.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

class ConsoleInputCarNameTest extends NsTest {

    Validator validator = new Validator();
    Input consoleInput = new ConsoleInput(validator);


    @Test
    void 자동차_이름_입력() {
        String input = "abc,def,ghij,klmno,p";

        run(input);
        assertThat(output()).contains("abc", "def", "ghij", "klmno", "p");
    }

    @Test
    void 자동차_이름_입력_숫자포함() {
        String input = "abc12,def,ghij3,klmno,p";

        run(input);
        assertThat(output()).contains("abc12", "def", "ghij3", "klmno", "p");
    }

    @Test
    void 자동차_이름_입력_예외_5글자_이상() {
        String input = "abchjhj,def,ghij,klmno,p";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력_예외_이름_중복() {
        String input = "abc,def,abc,klmno,p";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력_예외_이름_한글포함() {
        String input = "두,def,gh";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력_예외_이름_특수문자_포함() {
        String input = "a@b#,def,gh";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력_예외_자동차_1대미만() {
        String input = "\0";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력_예외_자동차_10대초과() {
        String input = "a,b,c,d,e,f,g,h,i,j,k,l";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        consoleInput.receiveCarNamesAndMakeList()
                .forEach(car -> System.out.println(car.getName()));
    }
}