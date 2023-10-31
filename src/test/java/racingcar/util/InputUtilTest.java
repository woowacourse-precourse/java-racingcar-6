package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("InputUtilTest")
class InputUtilTest {

    @Test
    @DisplayName("주어진 문자열을 리스트로 변환한다.")
    void convertInputStringToList() {
        //given
        String input = "holy,pig,eon";

        //when
        List<String> names = InputUtil.convertInputStringToList(input);

        //then
        assertThat(names).isEqualTo(List.of("holy", "pig", "eon"));
    }
}