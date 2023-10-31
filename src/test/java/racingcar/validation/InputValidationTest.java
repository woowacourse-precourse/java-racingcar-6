package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class InputValidationTest {
    private static InputValidation inputValidation;
    private static final int NAME_SIZE = 5;


    @BeforeEach
    void beforeEach() {
        inputValidation = new InputValidation();
    }

    @Test
    void 자동차_이름_형태_유효성_확인() {
        inputValidation.validateCarNameSize("pobi", NAME_SIZE);
    }

    @Test
    void 자동차_이름_예외처리() {
        assertThatThrownBy(() -> inputValidation.validateCarNameSize("", NAME_SIZE)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("Input invalid : input value is blank");

        assertThatThrownBy(() -> inputValidation.validateCarNameSize(" ", NAME_SIZE)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("Input invalid : input value is blank");

        assertThatThrownBy(() -> inputValidation.validateCarNameSize(null, NAME_SIZE)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("Input invalid : input value is null");
        assertThatThrownBy(() -> inputValidation.validateCarNameSize("\n", NAME_SIZE)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("Input invalid : input value is blank");

        assertThatThrownBy(() -> inputValidation.validateCarNameSize("123456", NAME_SIZE)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("Input invalid : size of input value exceeds " + NAME_SIZE);
    }

    @Test
    void 이동_차수_입력_유효성_확인() {
        inputValidation.validateMovingCount("7");
    }

    @Test
    void 이동_차수_입력_예외() {
        assertThatThrownBy(() -> inputValidation.validateMovingCount("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input invalid : input value is blank");

        assertThatThrownBy(() -> inputValidation.validateMovingCount(null)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input invalid : input value is null");

        assertThatThrownBy(() -> inputValidation.validateMovingCount("\n")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input invalid : input value is blank");

        assertThatThrownBy(() -> inputValidation.validateMovingCount("pobi")).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("Invalid input String:", "For input string:", "\"pobi\"");

    }


}
