package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.Validate;

public class ValidateTest {

    private Validate validate;

    @BeforeEach
    void setUp() {
        validate = new Validate();
    }

    @Test
    @DisplayName("이름 길이가 0이면 에러")
    void 이름이_0이면_에러() {
        List<String> input = Arrays.asList("", "aaa");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validate.validateOverorZero(input);
        });
    }

    @Test
    @DisplayName("이름 길이가 5이상이면 에러")
    void 이름길이가_5이상이면_에러() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validate.validateOverorZero(Arrays.asList("aaaaaaa", "bb"));
        });
    }


    @Test
    void 중복된_이름_확인() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validate.validateDuplicate(Arrays.asList("aa", "aa", "bb"));
        });
    }

    @Test
    void 숫자아닌값_확인() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validate.validateNumber("123a"));
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
