package racingcar.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    Validator validator;

    @BeforeEach
    void setup() {
        validator = new Validator();
    }

    @Test
    @DisplayName("문자열숫자 정상적으로 숫자로 변환")
    void validateGameRoundSuccess() {
        String stringNumber = "5";
        assertEquals(5, validator.validateGameRound(stringNumber));
    }

    @Test
    @DisplayName("문자열 숫자가 아닌 문자가 들어오는 경우")
    void validateGameRoundFail() {
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateGameRound("test"));
    }

    @Test
    @DisplayName("차의 이름이 5보다 큰 경우")
    void validateCarNameLengthFail() {
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateCarName("carName"));
    }

    @Test
    @DisplayName("차의 이름에 공백이 존재하는 경우")
    void carNameHasBlank() {
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateCarName(" he l"));
    }

    @Test
    @DisplayName("차의 이름이 중복되는 경우")
    void carNamesDuplicated() {
        String[] cars = {"test", "hello", "test"};
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateCarNamesDuplicated(cars));
    }
}