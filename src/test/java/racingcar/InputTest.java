package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.InputValidator;
import racingcar.utils.StringConvertor;

public class InputTest {

    @Test
    void 이름_길이_예외_처리() {
        List<String> input = List.of("pobiiiii", "pobi", "goni");

        assertThatThrownBy(() -> InputValidator.checkNameLength(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 쉼표_이외_구분자_예외_처리() {
        String input = "pobi.goni!godoli,jun";

        assertThatThrownBy(() -> InputValidator.checkSeparator(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 이름_중복_예외_처리() {
        List<String> input = List.of("pobi", "gorani", "goni", "goni");

        assertThatThrownBy(() -> InputValidator.checkNameIsDuplicated(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 이름_미입력_예외_처리() {
        String input = "  ,goni,jun, ";
        List<String> carNames = StringConvertor.convertStringToList(StringConvertor.removeSpace(input));

        assertThatThrownBy(() -> InputValidator.checkNameIsExist(carNames)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나다", "0", "0가나다"})
    void 시도_횟수_예외_처리(String input) {
        assertThatThrownBy(() -> InputValidator.checkTryNumberIsInteger(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

}
