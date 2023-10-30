package racingcar.util;

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

    @DisplayName("Integer 타입 List에서 가장 큰 값을 찾는다.")
    @Test
    void find_max_integer() {
        // given
        List<Integer> integerList = List.of(1, 3, 4, 2, 9);

        // when
        Integer maxInteger = Utils.findMaxInteger(integerList);

        // then
        assertThat(maxInteger).isEqualTo(9);
    }

}
