package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

public class CarsNameValidatorTest {

    @Test
    public void 유효한_차_리스트_입력() {
        List<String> validCars = Arrays.asList("Tesla", "Ford", "Toyota");
        assertDoesNotThrow(() -> CarsNameValidator.checkValidCarsName(validCars));
    }

    @Test
    public void 비어있는_차_리스트_입력_예외발생() {
        List<String> emptyCars = Arrays.asList();
        assertThrows(IllegalArgumentException.class, () -> CarsNameValidator.checkValidCarsName(emptyCars));
    }

    @Test
    public void 중복된_차_리스트_입력_예외발생() {
        List<String> duplicateCars = Arrays.asList("Toyota", "Tesla", "Toyota");
        assertThrows(IllegalArgumentException.class, () -> CarsNameValidator.checkValidCarsName(duplicateCars));
    }
}
