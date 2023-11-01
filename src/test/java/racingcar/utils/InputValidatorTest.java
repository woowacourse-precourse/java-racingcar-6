package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @DisplayName("자동차 이름은 중복으로 입력될 수 없다")
    @Test
    void validateCarNames() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(null));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(List.of()));
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNames(Arrays.asList("a", "b", "b")));
    }

    @DisplayName("자동차 이름 길이는 5자를 넘길 수 없다")
    @Test
    void validateCarNameLength() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNameLength("longlonglongname"));
    }

    @DisplayName("라운드 은 1 이상의 숫자여야 한다")
    @Test
    void verifyRounds() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.verifyRounds(null));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.verifyRounds(" "));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.verifyRounds("0"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.verifyRounds("-1"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.verifyRounds("abc"));
    }
}
