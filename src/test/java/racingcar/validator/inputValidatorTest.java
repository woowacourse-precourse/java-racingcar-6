package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class inputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @Nested
    @DisplayName("자동차 이름 유효성 테스트")
    class nameTest {
        @Test
        @DisplayName("이름 정상 입력")
        void testValidNameInput() {
            Assertions.assertDoesNotThrow(() -> inputValidator.validateInputCarName("pobi,woni,jun"));
            Assertions.assertDoesNotThrow(() -> inputValidator.validateInputCarName("pobi,lee d,apple"));
            Assertions.assertDoesNotThrow(() -> inputValidator.validateInputCarName("pobi,lee,apple"));
        }

        @Test
        @DisplayName("이름 앞 공백 예외")
        void testStartingWithSpace() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("pobi, apple"));
        }

        @Test
        @DisplayName("이름 구분자가 ,가 아닌 경우 예외")
        void testInvalidDelimiter() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("pobi&apple&jun"));
        }

        @Test
        @DisplayName("한글이름 예외")
        void testKoreanName() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("한글이름"));
        }

        @Test
        @DisplayName("길이 예외")
        void testLongName() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("pobiii"));
        }
    }

    @Nested
    @DisplayName("시도 횟수 입력값 유효성 테스트")
    class inputTryValueTest {
        @Test
        @DisplayName("정상 입력")
        void testValidTryValue() {
            Assertions.assertDoesNotThrow(() -> inputValidator.validateInputTryCount("123"));
            Assertions.assertDoesNotThrow(() -> inputValidator.validateInputTryCount("103"));
            Assertions.assertDoesNotThrow(() -> inputValidator.validateInputTryCount("1"));
        }

        @Test
        @DisplayName("입력 앞에 공백이 있는 경우 예외")
        void testStartWithSpace() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputTryCount(" 123"));
        }

        @Test
        @DisplayName("맨 앞에 0이 있는 경우")
        void testStartWithZero() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputTryCount("0"));
            Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputTryCount("012"));
        }
    }
}