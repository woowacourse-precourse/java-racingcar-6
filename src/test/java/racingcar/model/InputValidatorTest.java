package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    public void setup() {
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("정상적인 입력값 검증")
    public void testValidateInputNumber_ValidInput() {
        String input = "5";
        int result = inputValidator.validateInputNumber(input);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("숫자가 아닌 입력값 검증")
    public void testValidateInputNumber_InvalidInput_NotANumber() {
        String input = "five";
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateInputNumber(input);
        });
    }

    @Test
    @DisplayName("공백을 포함한 숫자 입력값 검증")
    public void testValidateInputNumber_InvalidInput_NumberWithSpace() {
        String input = " 5";
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateInputNumber(input);
        });
    }

    @Test
    @DisplayName("정상적인 차 이름 분리 및 검증")
    public void testSplitAndValidateCarNames_ValidInput() {
        String carNames = "car1,car2,car3";
        List<String> result = inputValidator.splitAndValidateCarNames(carNames);
        assertEquals(3, result.size());
        assertEquals("car1", result.get(0));
        assertEquals("car2", result.get(1));
        assertEquals("car3", result.get(2));
    }

    @Test
    @DisplayName("빈 차 이름 검증")
    public void testSplitAndValidateCarNames_EmptyNames() {
        String carNames = ",, ,  ,,";
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.splitAndValidateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("너무 긴 차 이름 검증")
    public void testSplitAndValidateCarNames_TooLongNames() {
        String carNames = "carname1,longlongcarname2";
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.splitAndValidateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("중복된 차 이름 검증")
    public void testSplitAndValidateCarNames_DuplicateNames() {
        String carNames = "car1,car1,car2";
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.splitAndValidateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("사용자 입력 오류 검증")
    public void testSplitAndValidateCarNames_UserTypeError() {
        String carNames = ",,car1,,,car2,,,         ,car3,,,";
        List<String> result = inputValidator.splitAndValidateCarNames(carNames);
        assertEquals(3, result.size());
        assertEquals("car1", result.get(0));
        assertEquals("car2", result.get(1));
        assertEquals("car3", result.get(2));
    }

}