package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    @Test
    void 유효한_이름_테스트() {
        List<String> validCarNames = Arrays.asList("Car1", "Car2", "Car3");
        assertDoesNotThrow(() -> Validator.validateCarNames(validCarNames));
    }

    @Test
    void 이름에_대한_예외_처리_짧은_길이_오류() {
        List<String> invalidCarNames = Arrays.asList("", "Car2", "Car3");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(invalidCarNames));
    }

    @Test
    void 이름에_대한_예외_처리_긴_길이_오류() {
        List<String> invalidCarNames = Arrays.asList("Car1Car1Car1Car1", "Car2", "Car3");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(invalidCarNames));
    }

    @Test
    void 이름에_대한_예외_처리_유효하지_않은_문자_오류() {
        List<String> invalidCarNames = Arrays.asList("Car1!", "Car2", "Car3");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(invalidCarNames));
    }

    @Test
    void 이름에_대한_예외_처리_중복_오류() {
        List<String> invalidCarNames = Arrays.asList("Car1", "Car1", "Car2");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(invalidCarNames));
    }

    @Test
    void 유효한_숫자_테스트() {
        assertDoesNotThrow(() -> Validator.validateAttempts(5));
    }

    @Test
    void 숫자에_대한_예외_처리_음수_입력() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAttempts(-1));
    }

    @Test
    void 숫자에_대한_예외_처리_0_입력() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAttempts(0));
    }
}

