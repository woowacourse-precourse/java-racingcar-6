package racingcar.service;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.ErrorMessage.*;
import static racingcar.constant.RaceSetting.MAX_CAR_NAME_LENGTH;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidationServiceTest {

    @Test
    @DisplayName("자동차 이름을 올바르게 입력한다.")
    void validateCarNamesInputTest() {
        ValidationService validationService = new ValidationService();
        List<String> carNamesInput = List.of("A", "AB", "ABC");
        validationService.validateCarNamesInput(carNamesInput);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 빈 문자열이라면, 예외 처리한다.")
    @CsvSource({"'', 'AB', 'ABC'", "'A', ' ', 'ABC'", "'A', 'AB', '  '"})
    void validateCarNamesInputTest2(String carName1, String carName2, String carName3) {
        ValidationService validationService = new ValidationService();
        List<String> carNamesInput = List.of(carName1, carName2, carName3);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validationService.validateCarNamesInput(carNamesInput));

        assertThat(exception.getMessage()).isEqualTo(EMPTY_INPUT_ERROR.getMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름의 길이가 일정 값보다 긴 경우, 예외 처리한다.")
    @CsvSource({"'A', 'AB', 'ABCDE'", "'ABCDEF', 'A', 'ABC'"})
    void validateCarNamesInputTest3(String carName1, String carName2, String carName3) {
        ValidationService validationService = new ValidationService();
        List<String> carNamesInput = List.of(carName1, carName2, carName3);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validationService.validateCarNamesInput(carNamesInput));

        assertThat(exception.getMessage()).isEqualTo(
                format(LENGTH_INPUT_ERROR.getMessage(), MAX_CAR_NAME_LENGTH.getValue())
        );
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 중복되는 경우, 예외 처리한다.")
    @CsvSource({"'A', 'A', 'AB'", "'ABC', 'A', 'ABC'", "'AB', 'A', 'A'"})
    void validateCarNamesInputTest4(String carName1, String carName2, String carName3) {
        ValidationService validationService = new ValidationService();
        List<String> carNamesInput = List.of(carName1, carName2, carName3);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validationService.validateCarNamesInput(carNamesInput));

        assertThat(exception.getMessage()).isEqualTo(DUPLICATE_INPUT_ERROR.getMessage());
    }

    @Test
    @DisplayName("시도 횟수를 올바르게 입력한다.")
    void validateNumericInputTest() {
        ValidationService validationService = new ValidationService();
        String countInput = "5";
        validationService.validateNumericInput(countInput);
    }

    @ParameterizedTest
    @DisplayName("시도 횟수가 수가 아닌 경우, 예외 처리한다.")
    @CsvSource({"A", "5.5", "''", "' '"})
    void validateNumericInputTest2(String countInput) {
        ValidationService validationService = new ValidationService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validationService.validateNumericInput(countInput));

        assertThat(exception.getMessage()).isEqualTo(NUMERIC_INPUT_ERROR.getMessage());
    }
}