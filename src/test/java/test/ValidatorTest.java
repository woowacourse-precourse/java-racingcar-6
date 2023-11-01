package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

public class ValidatorTest {
    @Test
    void InpuRaceCount_Valid_Test() {
        assertDoesNotThrow(() -> Validator.InputRaceCount("4"));
    }

    @Test
    void InpuRaceCount_InValid_Test() {
        assertThrows(IllegalArgumentException.class, () -> Validator.InputRaceCount("가"));
    }

    @Test
    void InputName_Invalid_Name_Length() {
        List<String> cars = Arrays.asList("car123456", "car2", "car3");
        assertThrows(IllegalArgumentException.class, () -> Validator.InputCarName(cars));
    }

    @Test
    void InputName_Invalid_Name_Duplication() {
        List<String> cars = Arrays.asList("car", "car");
        assertThrows(IllegalArgumentException.class, () -> Validator.InputCarName(cars));
    }

}

