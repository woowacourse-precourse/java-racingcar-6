package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNamesInputValidatorTest {

    private final BasicValidator<String> carNamesInputValidator = new CarNamesInputValidator();

    @Test
    void validate() {
        Throwable isInputEmptyException = assertThrows(
                IllegalArgumentException.class,
                () -> carNamesInputValidator.validate("")
        );
        assertEquals("입력값이 없습니다.", isInputEmptyException.getMessage());

        Throwable hasCommaAtStartOrEndException = assertThrows(
                IllegalArgumentException.class,
                () -> carNamesInputValidator.validate(",a,b,c,")
        );
        assertEquals("자동차 이름은 쉼표로 시작하거나 끝날 수 없습니다.", hasCommaAtStartOrEndException.getMessage());

        Throwable hasLessThanTwoCarNamesException = assertThrows(
                IllegalArgumentException.class,
                () -> carNamesInputValidator.validate("a")
        );
        assertEquals("자동차 이름은 2개 이상이어야 합니다.", hasLessThanTwoCarNamesException.getMessage());

        Throwable hasDuplicateCarNamesException = assertThrows(
                IllegalArgumentException.class,
                () -> carNamesInputValidator.validate("a,b,a")
        );
        assertEquals("자동차 이름은 중복될 수 없습니다.", hasDuplicateCarNamesException.getMessage());

        Throwable hasSpecialCharactersException = assertThrows(
                IllegalArgumentException.class,
                () -> carNamesInputValidator.validate("a%,b@")
        );
        assertEquals("자동차 이름에는 특수문자가 포함될 수 없습니다.", hasSpecialCharactersException.getMessage());

        Throwable isEachCarNameLengthValidException = assertThrows(
                IllegalArgumentException.class,
                () -> carNamesInputValidator.validate("abcdef,abc")
        );
        assertEquals("자동차 이름은 1자 이상, 5자 이하만 가능합니다.", isEachCarNameLengthValidException.getMessage());

        assertDoesNotThrow(
                () -> carNamesInputValidator.validate("a,b,c")
        );
    }
}