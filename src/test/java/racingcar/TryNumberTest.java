package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.TryNumber;

@DisplayName("시도횟수 테스트")
public class TryNumberTest {
    TryNumber tryNumber = new TryNumber();
    private static final String expectedMessage = "1이상의 정수를 입력해주세요.";

    @DisplayName("예외처리")
    @Nested
    class Exception {
        @DisplayName("한글 입력")
        @Test
        void KoreanInputTesting() {

            String trynumber = "한글";

            Throwable exception = assertThrows(IllegalArgumentException.class,
                    () -> tryNumber.setClearTryNumber(trynumber));
            assertEquals(expectedMessage, exception.getMessage());
        }

        @DisplayName("영어 입력")
        @Test
        void EnglishInputTesting() {
            TryNumber tryNumber = new TryNumber();
            String trynumber = "English";

            Throwable exception = assertThrows(IllegalArgumentException.class,
                    () -> tryNumber.setClearTryNumber(trynumber));
            assertEquals(expectedMessage, exception.getMessage());
        }

        @DisplayName("특수문자 입력")
        @Test
        void signInputTesting() {
            TryNumber tryNumber = new TryNumber();
            String trynumber = "!!";

            Throwable exception = assertThrows(IllegalArgumentException.class,
                    () -> tryNumber.setClearTryNumber(trynumber));
            assertEquals(expectedMessage, exception.getMessage());
        }

        @DisplayName("0 입력")
        @Test
        void zeroInputTesting() {
            TryNumber tryNumber = new TryNumber();
            String trynumber = "0";

            Throwable exception = assertThrows(IllegalArgumentException.class,
                    () -> tryNumber.setClearTryNumber(trynumber));
            assertEquals(expectedMessage, exception.getMessage());
        }

        @DisplayName("음의 정수 입력")
        @Test
        void minusInputTesting() {
            TryNumber tryNumber = new TryNumber();
            String trynumber = "-1";

            Throwable exception = assertThrows(IllegalArgumentException.class,
                    () -> tryNumber.setClearTryNumber(trynumber));
            assertEquals(expectedMessage, exception.getMessage());
        }

        @DisplayName("실수 입력")
        @Test
        void floatInputTesting() {
            TryNumber tryNumber = new TryNumber();
            String trynumber = "0.5";

            Throwable exception = assertThrows(IllegalArgumentException.class,
                    () -> tryNumber.setClearTryNumber(trynumber));
            assertEquals(expectedMessage, exception.getMessage());
        }
    }

    @DisplayName("반환값 확인")
    @Nested
    class ReturnValue {
        @DisplayName("정수 반환")
        @Test
        void returnValue() {
            String input = "1";
            int realValue = 1;

            tryNumber.setClearTryNumber(input);
            int testing = tryNumber.getTryNumber();

            assertEquals(testing, realValue);
        }
    }
}
