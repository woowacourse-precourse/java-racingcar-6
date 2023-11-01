package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Racer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacerValidatorTest {

    @DisplayName("Racer 클래스 지원")
    @Test
    void checkSupport() {
        Validator validator = new RacerValidator();
        assertThat(validator.support(Racer.class)).isTrue();
    }

    @DisplayName("잘못된 구분자 입력시 예외")
    @ParameterizedTest(name = "{displayName}: {0}")
    @NullSource
    @ValueSource(strings = {"", " ", ",", ",car", ",,,,,", ",,dk", "a,b,c,,", "ㄱ,ㄴ,,,"})
    void checkRacer(String value) {
        Validator validator = new RacerValidator();
        assertThatThrownBy(() ->
                validator.validate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 이름 입력시 예외")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"ad,k,la,a,la", "l,l", "qwe,kz,pi,pi", "a, a,a ", "ba,l, ba"})
    void checkUnique(String value) {
        Validator validator = new RacerValidator();
        assertThatThrownBy(() ->
                validator.validate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
