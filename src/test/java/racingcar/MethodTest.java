package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import jdk.jfr.ValueDescriptor;
import org.junit.jupiter.api.Test;

public class MethodTest {
    @Test
    void 자동차_공백_입력() {
        String input = "";
        assertThatThrownBy(() -> Validator.checkCarInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error:");
    }

    @Test
    void 자동차_5자_이상_이름_입력() {
        String input = "abcdefg";
        assertThatThrownBy(() -> Validator.checkCarInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error:");
    }

    @Test
    void 자동차_공백_포함() {
        String input = "a vcd";
        assertThatThrownBy(() -> Validator.checkCarInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error:");
    }

    @Test
    void 자동차_쉼표앞_공백() {
        String input = " ,vcd";
        assertThatThrownBy(() -> Validator.checkCarInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error:");
    }

    @Test
    void 자동차_이름_중복() {
        String input = "test,test";
        assertThatThrownBy(() -> Validator.checkCarInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error:");
    }

    @Test
    void 라운드_실수_입력() {
        String input = "1.3";
        assertThatThrownBy(() -> Validator.checkRoundInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error:");
    }

    @Test
    void 라운드_문자_입력() {
        String input = "aa";
        assertThatThrownBy(() -> Validator.checkRoundInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error:");
    }

    @Test
    void 라운드_음수_입력() {
        String input = "-1";
        assertThatThrownBy(() -> Validator.checkRoundInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error:");
    }

    @Test
    void 라운드_0_입력() {
        String input = "0";
        assertThatThrownBy(() -> Validator.checkRoundInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error:");
    }




}
