package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationServiceTest {

    ValidationService validationService = new ValidationService();

    @Test
    void validateCarsRange_ValidInput() {
        String cars = "car1,car2,car3";
        List<String> expected = Arrays.asList("car1", "car2", "car3");

        List<String> result = validationService.validateCarsRange(cars);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void validateCarsRange_InvalidInput_ThrowsException() {
        String cars = " ";

        assertThatThrownBy(() -> validationService.validateCarsRange(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarsName_ValidInput() {
        List<String> names = Arrays.asList("car1", "car2");

        // No exception should be thrown
        validationService.validateCarsName(names);
    }

    @Test
    void validateCarsName_InvalidInput_ThrowsException() {
        List<String> names = List.of("car123456");

        assertThatThrownBy(() -> validationService.validateCarsName(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRoundType_ValidInput() {
        String round = "5";
        int expected = 5;

        int result = validationService.validateRoundType(round);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void validateRoundType_InvalidInput_ThrowsException() {
        String round = "not_a_number";

        assertThatThrownBy(() -> validationService.validateRoundType(round))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRoundRange_InvalidInput_TooLow() {
        int invalidRoundTooLow = 0;

        assertThatThrownBy(() -> {
            new ValidationService().validateRoundRange(invalidRoundTooLow);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRoundRange_InvalidInput_TooHigh() {
        int invalidRoundTooHigh = 101;

        assertThatThrownBy(() -> {
            new ValidationService().validateRoundRange(invalidRoundTooHigh);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}