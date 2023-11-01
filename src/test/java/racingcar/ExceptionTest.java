package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    private Exception exception;

    @BeforeEach
    void beforeEach() {
        exception = new Exception();
    }

    @Test
    void 입력값_쉼표로_시작하지_않는다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.validateInputNotStartWithComma(",abcd");
        });

        Assertions.assertDoesNotThrow(() -> {
            exception.validateInputNotStartWithComma("abcd");
        });
    }

    @Test
    void 입력값_쉼표로_끝나지_않는다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.validateInputNotEndWithComma("abcd,");
        });

        Assertions.assertDoesNotThrow(() -> {
            exception.validateInputNotEndWithComma("abcd");
        });
    }

    @Test
    void 입력값_쉼표_중복_X() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.validateInputContainsConsecutiveCommas("ab,,cd");
        });

        Assertions.assertDoesNotThrow(() -> {
            exception.validateInputContainsConsecutiveCommas("ab,cd");
        });
    }


    @Test
    void 자동차이름_5자_이하() {
        String[] carNames1 = {"ab", "cd"};
        Assertions.assertDoesNotThrow(() -> {
            exception.validateNumberOfCarName(carNames1);
        });

        String[] carNames2 = {"ab", "cd", "kimyeonsu"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.validateNumberOfCarName(carNames2);
        });
    }

    @Test
    void 자동차이름_중복_X() {
        String[] splitCarName1 = {"a", "b", "c"};
        Assertions.assertDoesNotThrow(() -> {
            exception.validateDuplicateCarName(splitCarName1);
        });

        String[] splitCarName2 = {"a", "b", "a"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.validateDuplicateCarName(splitCarName2);
        });
    }
}
