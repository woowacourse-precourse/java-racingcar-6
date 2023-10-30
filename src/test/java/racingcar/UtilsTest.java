package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @DisplayName("정상적으로 ','로 파싱이 된다.")
    @Test
    void parse_carName() {
        // given
        String validInput = "i,am,sully";

        // when
        List<String> carNames = Utils.parseCarName(validInput);

        // then
        assertThat(carNames).containsExactly("i", "am", "sully");
    }

}
