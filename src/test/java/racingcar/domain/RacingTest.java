package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RacingTest")
public class RacingTest {

    @Test
    @DisplayName("성공 : 이름에 빈 문자열 기입")
    public void 이름에_빈_문자열_기입() {
        String input = "";

        final Racing racing = new Racing();

        assertThatThrownBy(() -> racing.getCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5자로 입력해주세요.");
    }


    @Test
    @DisplayName("성공 : 이름에 콤마 연속 삽입")
    public void 이름에_콤마_연속_삽입() {
        String input = "1,,2";

        final Racing racing = new Racing();

        assertThatThrownBy(() -> racing.getCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5자로 입력해주세요.");
    }
}
