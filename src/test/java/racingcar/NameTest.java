package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.InputValidator;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi.woni.jun", "pobi     , woni,   jun", ",pobi,jun", "pobi,woni,jun,"})
    @DisplayName("자동차 이름이 쉼표로 구분되지 않거나, 공백이 포함되거나, 쉼표가 앞뒤로 있으면 실패")
    void validateCarsFormat_실패(String input) {
        assertThatThrownBy(() -> InputValidator.validateCarsFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 쉼표로 구분되어 있거나, 이름이 1개만 입력되는 경우 성공")
    void validateCarsFormat_성공() {
        assertThat(InputValidator.validateCarsFormat("pobi,woni,jun")).containsExactly("pobi", "woni", "jun");
        assertThat(InputValidator.validateCarsFormat("p")).containsExactly("p");
    }

    @ParameterizedTest
    @ValueSource(strings = {"woooni", "", "hihihihihi"})
    @DisplayName("자동차 이름이 6자 이상이거나, 0자이면 실패")
    void validateCarNameValid_실패(String input) {
        assertThatThrownBy(() -> InputValidator.validateCarNameValid(List.of(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"woni", "p", "pobi"})
    @DisplayName("자동차 이름이 1~5자이면 성공")
    void validateCarNameValid_성공(String input) {
        assertThat(InputValidator.validateCarNameValid(List.of(input))).isTrue();
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 실패")
    void validateUniqueCarName_실패() {
        assertThatThrownBy(() -> InputValidator.validateUniqueCarName(List.of("pobi", "wooni", "pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 고유하면 성공")
    void validateUniqueCarName_성공() {
        assertThat(InputValidator.validateUniqueCarName(List.of("pobi", "wooni", "abc"))).isTrue();
    }
}
