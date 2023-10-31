package racingcar.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {


    @Test
    void checkCarNameSize() {
        List<String> carNamesLessThan1 = List.of();
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameSize(carNamesLessThan1);
        });

        List<String> carNamesEqual1 = List.of("Toyota");
        Validator.checkCarNameSize(carNamesEqual1);

        List<String> carNamesGreaterThan8 = List.of("Audi", "BMW", "Mercedes", "Toyota", "Ford", "Hyundai", "Kia", "Nissan", "Chevrolet");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameSize(carNamesGreaterThan8);
        });
    }

    @Test
    void checkCarNameDuplication() {
    }

    @Test
    void checkCarNameIsEnglish() {
    }
}