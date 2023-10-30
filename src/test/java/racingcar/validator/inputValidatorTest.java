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
            // given
            String names1 = "pobi,woni,jun";
            String names2 = "pobi,lee,apple";
            String names3 = "pobi,lee";

            // when
            // then
            assertDoesNotThrow(() -> inputValidator.validateInputCarName(names1));
            assertDoesNotThrow(() -> inputValidator.validateInputCarName(names2));
            assertDoesNotThrow(() -> inputValidator.validateInputCarName(names3));
        }

        @Test
        @DisplayName("공백이 있을 경우 예외")
        void testWithSpace() {
            // given
            String namesWithSpace = "pobi, apple";

            // when
            // then
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName(namesWithSpace));
        }

        @Test
        @DisplayName("이름 구분자가 ,가 아닌 경우 예외")
        void testInvalidDelimiter() {
            // given
            String invalidDelimiterNames = "pobi&apple&jun";

            // when
            // then
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName(invalidDelimiterNames));
        }

        @Test
        @DisplayName("한글이름 예외")
        void testKoreanName() {
            // given
            String koreanNames = "한글이름1,한글이름2";

            // when
            // then
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName(koreanNames));
        }

        @Test
        @DisplayName("길이 예외")
        void testLongName() {
            // given
            String overLengthNames = "pobiii, applee";

            // when
            // then
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName(overLengthNames));
        }
    }

    @Nested
    @DisplayName("시도 횟수 입력값 유효성 테스트")
    class inputTryValueTest {
        @Test
        @DisplayName("정상 입력")
        void testValidTryValue() {
            // given
            String tryValue1 = "123";
            String tryValue2 = "103";
            String tryValue3 = "1";

            // when
            // then
            assertDoesNotThrow(() -> inputValidator.validateInputTryCount(tryValue1));
            assertDoesNotThrow(() -> inputValidator.validateInputTryCount(tryValue2));
            assertDoesNotThrow(() -> inputValidator.validateInputTryCount(tryValue3));
        }

        @Test
        @DisplayName("입력 앞에 공백이 있는 경우 예외")
        void testStartWithSpace() {
            // given
            String startWithSpaceTryValue = " 123";

            // when
            // then
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputTryCount(startWithSpaceTryValue));
        }

        @Test
        @DisplayName("맨 앞에 0이 있는 경우")
        void testStartWithZero() {
            // given
            String zeroTryValue = "0";
            String startWithZeroTryValue = "012";

            // when
            // then
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputTryCount(zeroTryValue));
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputTryCount(startWithZeroTryValue));
        }
    }
}