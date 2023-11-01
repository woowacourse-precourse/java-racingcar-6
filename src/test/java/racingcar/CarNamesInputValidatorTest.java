package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.CarNamesInputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarNamesInputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"Audi", "Audi,Kia", "Audi,Kia,Tesla"})
    void validate_쉼표로_구분된_5자_이하의_자동차_이름은_예외_미발생(String input) {
        assertDoesNotThrow(() -> CarNamesInputValidator.validate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Toyota", "Audi,Toyota", "Toyota,Volkswagen"})
    void validate_쉼표로_구분된_자동차_이름_길이가_설정_값을_초과할_때_예외_발생(String input) {
        assertThatThrownBy(() -> CarNamesInputValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Audi,", "Audi,,Tesla", "Audi,  ,Tesla", ",Audi,Tesla"})
    void validate_쉼표로_구분된_자동차_이름_길이가_0일_때_예외_발생(String input) {
        assertThatThrownBy(() -> CarNamesInputValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void validate_빈_입력_일_때_예외_발생(String input) {
        assertThatThrownBy(() -> CarNamesInputValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
