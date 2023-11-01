package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    public void testValidateName() {
        // 길이가 5 이하인 이름에 대해 예외가 발생하지 않는지 확인
        assertDoesNotThrow(() -> Validator.validateName("name1"));

        // 길이가 5 초과인 이름에 대해 예외가 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> Validator.validateName("tooLongName"));

        // 빈 문자열에 대해 예외가 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> Validator.validateName(""));

        // 공백 문자열에 대해 예외가 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> Validator.validateName(" "));
    }

    @Test
    public void testValidateNumberOfMove() {
        // 이동 횟수가 양수일 때 예외가 발생하지 않는지 확인
        assertDoesNotThrow(() -> Validator.validateNumberOfMove(1));

        // 이동 횟수가 0일 때 예외가 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNumberOfMove(0));

        // 이동 횟수가 음수일 때 예외가 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNumberOfMove(-1));
    }
}
