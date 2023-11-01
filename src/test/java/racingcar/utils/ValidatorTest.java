package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    public void 유효한_자동차_이름들만_입력() {
        Validator.validateCarNames(List.of("Car1", "Car2", "Car3"));
    }

    @Test
    public void 자동차_수를_부족하게_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames(List.of("Car1"));
        });
    }

    @Test
    public void 자동차_이름_길이_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames(List.of("Car123456"));
        });
    }

    @Test
    public void 유효한_시도_횟수를_입력() {
        Validator.validateAttemptsNumber(3);
    }

    @Test
    public void 시도_횟수를_0이하로_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateAttemptsNumber(0);
        });
    }
}

