package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.ErrorMessage;
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

    @Test
    @DisplayName("사용자의 입력이 숫자로 변경 되는가?")
    void testConvertToInt() {
        String input = "4";

        assertThat(Converter.convertStringToInt(input)).isEqualTo(4);
    }

    @Test
    @DisplayName("사죵자의 입력이 숫자가 아닐때, 에러를 출력하는가?")
    void testErrorConvertToInt() {
        String input = "다섯번";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> Converter.convertStringToInt(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.ERROR_NAME_MUST_BE_NUMBER.getMessage());
    }
}
