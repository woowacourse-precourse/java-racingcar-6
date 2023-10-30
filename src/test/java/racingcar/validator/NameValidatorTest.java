package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameValidatorTest {

    @Test
    void validate() {
        Throwable hasSpecialCharactersException = assertThrows(
                IllegalArgumentException.class,
                () -> new NameValidator().validate("a!@#$%^&*")
        );
        assertEquals("자동차 이름에는 특수문자가 포함될 수 없습니다.", hasSpecialCharactersException.getMessage());

        Throwable isCarNameLengthValidException = assertThrows(
                IllegalArgumentException.class,
                () -> new NameValidator().validate("abcdef")
        );
        assertEquals("자동차 이름은 1자 이상, 5자 이하만 가능합니다.", isCarNameLengthValidException.getMessage());

        Throwable isCarNameLengthValidException2 = assertThrows(
                IllegalArgumentException.class,
                () -> new NameValidator().validate("")
        );
        assertEquals("자동차 이름은 1자 이상, 5자 이하만 가능합니다.", isCarNameLengthValidException2.getMessage());

        assertDoesNotThrow(
                () -> new NameValidator().validate("a")
        );
    }
}