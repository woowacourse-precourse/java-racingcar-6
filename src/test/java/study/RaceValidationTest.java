package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validation.RaceValidator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceValidationTest {
    private RaceValidator raceValidation = new RaceValidator();
    @Test
    @DisplayName("자동차 이름 입력에 쉼포가 없으면 예외 발생")
    void validateSeparator() {
        String includeComma = "자동차1,자동차2";
        String unIncludeComma = "자동차1자동차2";
        assertThatNoException().isThrownBy(() -> raceValidation.validateSeparator(includeComma));
        assertThatThrownBy(() -> raceValidation.validateSeparator(unIncludeComma)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("자동차 이름 5글자 넘길 시 예외 발생")
    void validateNameLength() {
        String carName1 = "마이바흐";
        String carName2 = "롤스로이스 고스트";
        assertThatNoException().isThrownBy(() -> raceValidation.validateCarname(carName1));
        assertThatThrownBy(() -> raceValidation.validateCarname(carName2)).isInstanceOf(IllegalArgumentException.class);
    }
}
