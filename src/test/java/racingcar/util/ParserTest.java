package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @DisplayName("정상적으로 ','로 파싱이 된다.")
    @Test
    void parseCarName() {
        // given
        String validInput = "i,am,sully";

        // when
        List<String> carNames = Parser.parseCarName(validInput);

        // then
        assertThat(carNames).containsExactly("i", "am", "sully");
    }

}
