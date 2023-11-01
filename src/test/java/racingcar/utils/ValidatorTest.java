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

        List<String> carNamesEqual1 = List.of(" Toyota");
        Validator.checkCarNameSize(carNamesEqual1);

        List<String> carNameIsEmpty = List.of("Audi","    ");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameSize(carNameIsEmpty);
        });

        List<String> carNamesGreaterThan8 = List.of("Audi", "BMW", "Mercedes", "Toyota", "Ford", "Hyundai", "Kia", "Nissan", "Chevrolet");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameSize(carNamesGreaterThan8);
        });
    }

    @Test
    void checkCarNameDuplication() {
        List<String> carNamesNoDuplication = List.of("Ferrari", "Lamborghini", "Ford");
        Validator.checkCarNameDuplication(carNamesNoDuplication);

        List<String> carNamesWithDuplication = List.of("Ferrari", "Ford", "Lamborghini", "Ferrari");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameDuplication(carNamesWithDuplication);
        });

        List<String> emptyCarNames = List.of();
        Validator.checkCarNameDuplication(emptyCarNames);
    }

    @Test
    void checkCarNameIsEnglish() {
        List<String> carNamesEnglish = List.of("BMW", "Honda", "Ford");
        Validator.checkCarNameIsEnglish(carNamesEnglish);

        List<String> carNamesNonEnglish = List.of("Ferrari", "Ford", "페라리");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameIsEnglish(carNamesNonEnglish);
        });

        List<String> carNamesNonEnglish2 = List.of("@", "!", "페라리");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameIsEnglish(carNamesNonEnglish2);
        });

        List<String> emptyCarNames = List.of();
        Validator.checkCarNameIsEnglish(emptyCarNames);
    }

    @Test
    void checkTryCountNumber(){
        String validTryCount = "5";
        Validator.checkTryCountNumber(validTryCount);

        String invalidTryCount1 = "0";
        String invalidTryCount2 = "-123";
        String invalidTryCount3 = "abc";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkTryCountNumber(invalidTryCount1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkTryCountNumber(invalidTryCount2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkTryCountNumber(invalidTryCount3);
        });

        String emptyTryCount = "";
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkTryCountNumber(emptyTryCount);
        });

        String nullTryCount = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkTryCountNumber(nullTryCount);
        });
    }

    @Test
    void testCheckCarNameLength() {
        List<String> validCarNames = List.of("Audi", "BMW", "Ford");
        Validator.checkCarNameLength(validCarNames);

        List<String> invalidCarNames = List.of("Mercedes", "Toyota123");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameLength(invalidCarNames);
        });
    }
}