package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.controller.InputValidator.*;

import org.junit.jupiter.api.Test;

public class validationTest {

    @Test
    void name_Validation_Test() {

        // 이름의 길이가 5를 넘었을 경우
        assertThatThrownBy(() -> {
            nameValidation("longname,short");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument: longname");

        // 쉼표만 입력되었을 경우
        assertThatThrownBy(() -> {
            nameValidation(",,,");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument: empty names");

        // 입력값이 비었을 경우
        assertThatThrownBy(() -> {
            nameValidation("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument: empty names");

    }

    @Test
    void number_Validation_Test() {

        // 음수 입력
        assertThatThrownBy(() -> {
            numberValidation("-1");
        }).isInstanceOf(IllegalArgumentException.class);

        // 숫자가 아닌 값 입력
        assertThatThrownBy(() -> {
            numberValidation("notNumber");
        }).isInstanceOf(IllegalArgumentException.class);

        // 숫자가 아닌 값 입력
        assertThatThrownBy(() -> {
            numberValidation("1,2");
        }).isInstanceOf(IllegalArgumentException.class);

    }

}
