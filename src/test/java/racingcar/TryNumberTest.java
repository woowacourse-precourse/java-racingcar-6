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

    @DisplayName("예외처리")
    @Nested
    class Exception {
        @DisplayName("한글입력")
        @Test
        void KoreanInputTesting() {

            String trynumber = "한글";

            Throwable exception = assertThrows(IllegalArgumentException.class,
                    () -> tryNumber.setClearTryNumber(trynumber));
            assertEquals("시도할 회수는 1보다 큰 자연수여야 합니다.", exception.getMessage());
        }

        @DisplayName("영어입력")
        @Test
        void EnglishInputTesting() {
            TryNumber tryNumber = new TryNumber();
            String trynumber = "English";

            Throwable exception = assertThrows(IllegalArgumentException.class,
                    () -> tryNumber.setClearTryNumber(trynumber));
            assertEquals("시도할 회수는 1보다 큰 자연수여야 합니다.", exception.getMessage());
        }

        @DisplayName("특수문자입력")
        @Test
        void signInputTesting() {
            TryNumber tryNumber = new TryNumber();
            String trynumber = "!!";

            Throwable exception = assertThrows(IllegalArgumentException.class,
                    () -> tryNumber.setClearTryNumber(trynumber));
            assertEquals("시도할 회수는 1보다 큰 자연수여야 합니다.", exception.getMessage());
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
