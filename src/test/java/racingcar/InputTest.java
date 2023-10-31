package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
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
    void 이름_공백_제거_확인() {
        String input = " pobi,goni ,  jun  ";
        List<String> result = List.of("pobi", "goni", "jun");

        assertThat(StringConvertor.convertStringToList(input)).isEqualTo(result);
    }

    @Test
    void 이름_미입력_예외_처리() {
        String input = "  ,goni,jun, ";
        assertThatThrownBy(() -> InputValidator.checkNameIsExist(
                StringConvertor.convertStringToList(input))).isInstanceOf(
                IllegalArgumentException.class);
    }

}
