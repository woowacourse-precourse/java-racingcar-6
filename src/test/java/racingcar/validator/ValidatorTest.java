package racingcar.validator;

import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 자동차_이름이_5글자_초과일때_예외_발생() {
        //given
        List<String> invalidNames = Arrays.asList("Car123456", "Car2", "Car3");

        // When and Then
        assertThatThrownBy(() -> Validator.validateCarName(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_MORE_THAN_FIVE.getMessage());
    }

    @Test
    void 자동차_이름에_공백이_있을때_예외_발생() {
        //given
        List<String> invalidNames = Arrays.asList("Car 1", "Car2", "Car3");

        // When and Then
        assertThatThrownBy(() -> Validator.validateCarName(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NO_SPACE_ALLOWED.getMessage());
    }

    @Test
    void 자동차_이름이_빈문자열일때_예외_발생() {
        //given
        List<String> invalidNames = Arrays.asList("Car1", "", "Car3");

        // When and Then
        assertThatThrownBy(() -> Validator.validateCarName(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_EMPTY_ALLOWED.getMessage());
    }

    @Test
    void 시도할_회수가_숫자가_아닐때_예외_발생() {
        //given
        String invalidCnt = "abc123";

        // When and Then
        assertThatThrownBy(() -> Validator.validateTryCnt(invalidCnt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_NUMERIC.getMessage());
    }
}