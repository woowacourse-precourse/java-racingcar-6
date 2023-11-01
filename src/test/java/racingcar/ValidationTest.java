package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validation.Validation;

public class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"!@$@$@$@", "!!", "1,2,,4,5", "가나다,라마바,사아자"})
    @DisplayName("영문자는 입력할 수 있습니다. IllegalArgumentException")
    void stringValidationTest1(String name) {
        assertThatThrownBy(() -> Validation.validateApplicantCars(name))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "fghhijl", "aa,abbbbbb", ""})
    @DisplayName("1글자 이상 5글자 이하만 입력할 수 있습니다. IllegalArgumentException")
    void stringValidationTest2(String name) {
        assertThatThrownBy(() -> Validation.validateApplicantCars(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd, abd", " "})
    @DisplayName("공백은 입력할 수 없습니다. IllegalArgumentException")
    void stringValidationTest3(String name) {
        assertThatThrownBy(() -> Validation.validateApplicantCars(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-9"})
    @DisplayName("음수는 입력할 수 없습니다. IllegalArgumentException")
    void numberValidationTest1(String raceCount) {
        assertThatThrownBy(() -> Validation.validateRaceCount(raceCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㅁㄹ", "a", " "})
    @DisplayName("정수 외에 값은 입력할 수 없습니다. IllegalArgumentException")
    void numberValidationTest2(String raceCount) {
        assertThatThrownBy(() -> Validation.validateRaceCount(raceCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
