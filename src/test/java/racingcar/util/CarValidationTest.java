package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarValidationTest {


    @Test
    public void Car_하나만입력() {
        List<String> carNames = Arrays.asList("hwan");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> CarValidation.validateCars(carNames));
        assertEquals("자동차는 최소 2개가 필요합니다.", exception.getMessage());
    }


    @Test
    public void CarName_중복입력() {
        List<String> carNames = Arrays.asList("hwan", "hwan");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> CarValidation.validateOverlap(carNames));
        assertEquals("이름들 간에 중복이 있습니다.", exception.getMessage());
    }


}