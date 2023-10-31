package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.Validate;

public class ValidateTest {

    private Validate validate;

    @BeforeEach
    void setUp() {
        validate = new Validate();
    }

    @Test
    void checkNone() {
        // given
        List<String> input = Arrays.asList("", "aaa");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validate.validateOverorZero(input);
        });
    }

    @Test
    void checkOverFiveLen() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validate.validateOverorZero(Arrays.asList("aaaaaaa", "bb"));
        });
    }


    @Test
    void checkDuplicate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validate.validateDuplicate(Arrays.asList("aa", "aa", "bb"));
        });
    }

    @Test
    void 숫자_알파벳() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validate.validateInteger("123a"));
    }

    @Test
    void 숫자_마침표() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validate.validateInteger("12.1"));
    }

    // TODO 함수명 바꿔라
    @Test
    void 이름_에러없음() {
        Assertions.assertDoesNotThrow(
                () -> validate.validateOverorZero(Arrays.asList("aa", "bb")));
        Assertions.assertDoesNotThrow(
                () -> validate.validateDuplicate(Arrays.asList("aa", "bb")));
    }
}
