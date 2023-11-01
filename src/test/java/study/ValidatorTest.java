package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.Validator;

public class ValidatorTest {
    @ParameterizedTest
    @EmptySource
    void input_null_car_name(String nullAndEmpty) {
        assertThatThrownBy(() -> Validator.validNameFormat(nullAndEmpty)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @EmptySource
    void input_null_round_number(String nullAndEmpty) {
        assertThatThrownBy(() -> Validator.validIsNumber(nullAndEmpty)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"자동차1", "car11","*(&&",","})
    void input_not_allowed_car_name(String testString) {
        assertThatThrownBy(() -> Validator.validNameFormat(testString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"name"})
    void input_only_single_car_name(String singleName) {
        assertThatThrownBy(() -> Validator.validSingleName(singleName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void input_zero_round_number(String zero) {
        assertThatThrownBy(() -> Validator.validNotZero(zero)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"일", "two", "??"})
    void input_not_allowed_round_number(String testString) {
        assertThatThrownBy(() -> Validator.validIsNumber(testString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"차차차차차차", "carcarcar", "ccccccccccc"})
    void input_not_allowed_length_car_name(String testString) {
        assertThatThrownBy(() -> Validator.validLength(testString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun,포비,우니,준"})
    void input_allowed_car_name(String testString) {
        assertThatCode(() ->{
            Validator.validNameFormat(testString);
            Validator.validSingleName(testString);}).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "1", "1000"})
    void input_allowed_round_number(String testString) {
        assertThatCode(() -> {Validator.validIsNumber(testString);
            Validator.validNotZero(testString);}).doesNotThrowAnyException();
    }
}
