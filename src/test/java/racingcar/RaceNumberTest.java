package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RaceNumber;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceNumberTest {
    @Test
    @DisplayName("숫자가 아니라면 예외를 발생시킨다.")
    void givenNotNumber_whenCreateRaceNumber_thenFail() {
        // given
        String input = "a";
        // when & then
        assertThatThrownBy(() -> RaceNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }
}
