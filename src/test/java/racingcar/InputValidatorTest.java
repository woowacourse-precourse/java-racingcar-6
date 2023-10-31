package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class InputValidatorTest {

    @Test
    void 문자열_형식오류_예외발생_테스트() {
        assertThrowsIllegalArgumentException(() -> InputValidator.validateString("@@$"));
    }

    @Test
    void 차이름_5자이하_테스트() {
        assertTrue(InputValidator.validateCarName("pbi"));
    }

    @Test
    void 차이름_오류_예외발생_테스트() {
        assertThrowsIllegalArgumentException(() -> InputValidator.validateCarName("pobisportscar"));
    }

    @Test
    void 시도입력_유효_테스트() {
        assertTrue(InputValidator.validateRounds("5"));
    }

    @Test
    void 시도입력_형식오류_예외발생_테스트() {
        assertThrowsIllegalArgumentException(() -> InputValidator.validateString("ㅇ"));
    }

    @Test
    void 시도입력_음수_예외발생_테스트() {
        assertThrowsIllegalArgumentException(() -> InputValidator.validateString("ㅇ"));
    }


    private void assertThrowsIllegalArgumentException(Executable executable) {
        assertThrows(IllegalArgumentException.class, executable);
    }
}
