package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


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

    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    @NullSource
    @EmptySource
    void 자동차_이름_예외처리(String name) {
        assertThatThrownBy(() -> inputValidation.validateCarNameSize(name, NAME_SIZE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_차수_입력_유효성_확인() {
        inputValidation.validateMovingCount("7");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @NullSource
    @EmptySource
    void 이동_차수_입력_예외(String movingCount) {
        assertThatThrownBy(() -> inputValidation.validateMovingCount(movingCount))
                .isInstanceOf(IllegalArgumentException.class);

    }


}
