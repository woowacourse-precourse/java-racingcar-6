package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @DisplayName("parseCarName()로 정상적으로 ','로 파싱이 된다.")
    @Test
    void parse_carName() {
        // given
        String validInput = "i,am,sully";

        // when
        List<String> carNames = Utils.parseCarName(validInput);

        // then
        assertThat(carNames).containsExactly("i", "am", "sully");
    }

    @DisplayName("repeatDash()로 position의 수만큼 '-'가 생성된다.")
    @Test
    void repeat_dash() {
        // given
        int position = 5;

        // when
        Utils.repeatDash(position);

        // then
        assertThat(Utils.repeatDash(position)).isEqualTo("-----");
    }

}
