package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * 자동차 이름 유효성 검사가 제대로 이루어지는지 테스트합니다.
 */
public class CarNameValidatorTest {
    private static final String CAR_NAME_ERROR_MESSAGE = "잘못된 자동차 이름입니다.";

    @Test
    public void 유효한_자동차_이름들() {
        List<String> validCarNames = List.of("Car1", "Car_2", "C", "12345");
        assertDoesNotThrow(() -> {
            CarNameValidator.validate(validCarNames);
        });
    }

    @Test
    public void 너무_긴_자동차_이름() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(List.of("이게어떻게자동차이름", "이될수가있는거죠?", "Car1"));
        });
        String actualErrorMessage = exception.getMessage();
        assert (actualErrorMessage.contains(CAR_NAME_ERROR_MESSAGE));
    }

    @Test
    public void 중복된_자동차_이름() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(List.of("Car1", "Car1", "Car2"));
        });
        String actualErrorMessage = exception.getMessage();
        assert (actualErrorMessage.contains(CAR_NAME_ERROR_MESSAGE));
    }

    @Test
    public void 공백으로_이루어진_자동차_이름() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(List.of("Car1", " ", "Car2"));
        });
        String actualErrorMessage = exception.getMessage();
        assert (actualErrorMessage.contains(CAR_NAME_ERROR_MESSAGE));
    }

    @Test
    public void 자동차_이름에_null_포함() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(Arrays.asList("Car1", null, "Car2"));
        });
        String actualErrorMessage = exception.getMessage();
        assert (actualErrorMessage.contains(CAR_NAME_ERROR_MESSAGE));
    }


    @Test
    public void 자동차_이름_리스트가_비어있음() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(List.of());
        });
        String actualErrorMessage = exception.getMessage();
        assert (actualErrorMessage.contains(CAR_NAME_ERROR_MESSAGE));
    }

    @Test
    public void 자동차_이름_최소_2개_이상() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(List.of("Car1"));
        });
        String actualErrorMessage = exception.getMessage();
        assert (actualErrorMessage.contains(CAR_NAME_ERROR_MESSAGE));
    }
}
