package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.Converter;

public class InputTest {
    @Test
    @DisplayName("사용자 입력이 콤마(,)를 기준으로 나뉘어지는가?")
    void testStoreCarNames() {
        String input = "pobi,jun";
        List<String> names = Converter.convertStringToList(input);

        assertThat(names).isEqualTo(
                List.of("pobi", "jun")
        );
    }
}
