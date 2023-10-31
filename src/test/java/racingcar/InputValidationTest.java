package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.util.InputValueValidator;

public class InputValidationTest extends NsTest {

    InputValueValidator validator = new InputValueValidator();

    @DisplayName("이름 길이 예외 발생 테스트")
    @Test
    void isNameLength() {
        assertThatThrownBy(() -> {
            validator.validateName("abcdef");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_NAME_LENGTH.getMessage());
    }

    @DisplayName("이름 중복 예외 발생 테스트")
    @Test
    void isDuplicate() {
        assertThatThrownBy(() -> {
            validator.validateName("dui,dui,pobi");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_NAME_DUPLICATE.getMessage());
    }

    @DisplayName("이름 공백 포함 예외 발생 테스트")
    @Test
    void isNameSpace() {
        assertThatThrownBy(() -> {
            validator.validateName("    ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_NAME_NO_SPACES.getMessage());
    }

    @DisplayName("이름 공백 포함 예외 발생 테스트")
    @Test
    void isNameContainsSpace() {
        assertThatThrownBy(() -> {
            validator.validateName("dui, pobi");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_NAME_NO_SPACES.getMessage());
    }

    @DisplayName("이름 널값 예외 발생 테스트")
    @Test
    void isNullName() {
        assertThatThrownBy(() -> {
            validator.validateName("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_NAME_IS_NOT_NULL.getMessage());
    }

    @DisplayName("이름 최소 개수 예외 발생 테스트")
    @Test
    void isMinimumNameCount() {
        assertThatThrownBy(() -> {
            validator.validateName("dui");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_MINIMUM_NAMES.getMessage());
    }

    @DisplayName("시도 횟수 최소 개수 예외 발생 테스트")
    @Test
    void isMinimumTryCount() {
        assertThatThrownBy(() -> {
            validator.validateTryCount("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_MINIMUM_TRY_COUNT.getMessage());
    }

    @DisplayName("시도 횟수 음수 예외 발생 테스트")
    @Test
    void isTryCountIsNaturalNumber() {
        assertThatThrownBy(() -> {
            validator.validateTryCount("-12");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_MINIMUM_TRY_COUNT.getMessage());
    }

    @DisplayName("시도 횟수 널값 예외 발생 테스트")
    @Test
    void isNullTryCount() {
        assertThatThrownBy(() -> {
            validator.validateTryCount("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_TRY_COUNT_IS_NOT_NULL.getMessage());
    }

    @DisplayName("시도 횟수 숫자 허용 예외 발생 테스트")
    @Test
    void isTryCountNumber() {
        assertThatThrownBy(() -> {
            validator.validateTryCount("a1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_NUMBER_FORMAT_TRY_COUNT.getMessage());
    }

    @Override
    protected void runMain() {

    }
}
