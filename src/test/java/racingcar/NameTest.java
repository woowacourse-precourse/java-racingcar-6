package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Name;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"woooni", "", "hihihihihi"})
    @DisplayName("자동차 이름이 6자 이상이거나, 0자이면 실패")
    void validateCarNameValid_실패(String input) {
        assertThatThrownBy(() -> new Name(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"woni", "p", "pobi"})
    @DisplayName("자동차 이름이 1~5자이면 성공")
    void validateCarNameValid_성공(String input) {
        assertThat(new Name(input)).isNotNull();
    }
}