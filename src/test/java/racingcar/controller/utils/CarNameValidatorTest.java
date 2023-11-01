package racingcar.controller.utils;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class CarNameValidatorTest {

    @Test
    void 정상() {
        CarNameValidator validator = new CarNameValidator();
        String input = "Car1,Car2,Car3";
        assertThatCode(() -> validator.validateCarNameInput(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 공백입력_예외_처리() {
        CarNameValidator validator = new CarNameValidator();
        String input = "";
        assertThatThrownBy(() -> validator.validateCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값을 입력하세요");
    }

    @Test
    void 자동차_이름_길이_초과_예외_처리() {
        CarNameValidator validator = new CarNameValidator();
        String input = "Car1,Car2,Car3333333";
        assertThatThrownBy(() -> validator.validateCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5글자 이하여야 합니다.");
    }

    @Test
    void 자동차_이름_길이_미달_예외_처리() {
        CarNameValidator validator = new CarNameValidator();
        String input = ",Car2,Car3";
        assertThatThrownBy(() -> validator.validateCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 1글자 이상이어야 합니다.");
    }

    @Test
    void 자동차_이름_중복_발생_예외_처리() {
        CarNameValidator validator = new CarNameValidator();
        String input = "Car1,Car2,Car1";
        assertThatThrownBy(() -> validator.validateCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 중복이 있습니다.");
    }
}