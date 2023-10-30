package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.controller.InputValidator.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class validationTest {

    @ParameterizedTest
    @ValueSource(strings = {"longname,short", ",,,", ""})
    void name_Validation_Test(String player) {

        // 이름의 길이가 5를 넘었을 경우
        assertThatThrownBy(() -> {
            nameValidation(player);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "notNumber", "1,2"})
    void number_Validation_Test(String testNumber) {

        // 음수 입력
        assertThatThrownBy(() -> {
            numberValidation(testNumber);
        }).isInstanceOf(IllegalArgumentException.class);

    }

}
