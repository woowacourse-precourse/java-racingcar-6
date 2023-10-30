package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

class InputRacingCarTest {
    @Test
    void split_이름_구분() {
        List<String> result = InputRacingCar.nameSeparator("pobi,woni,jun");
        assertThat(result).contains("pobi", "jun", "woni");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void split_이름_구분자가_없을_경우_그대로_반환() {
        List<String> result = InputRacingCar.nameSeparator("pobi");
        assertThat(result).contains("pobi");
    }

    @Test
    void 이름이_5자_초과할때() {
        List<String> namesExceeds = List.of("pobi123", "jun");
        assertThatThrownBy(() -> {
            InputRacingCar.checkLength(namesExceeds);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_LENGTH_EXCEEDED_ERROR);
    }

    @Test
    void 이름이_0자_일때() {
        List<String> namesEmpty = List.of("");
        assertThatThrownBy(() -> {
            InputRacingCar.checkLength(namesEmpty);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_NAME_ERROR);
    }

    @Test
    void 이름이_정상길이_일때() {
        List<String> namesValid = List.of("pobii", "jun");
        assertThatCode(() -> {
            InputRacingCar.checkLength(namesValid);
        }).doesNotThrowAnyException();
    }

    @Test
    void 이름에_공백이_있을때() {
        List<String> namesWithSpace = List.of("poby,j un");
        assertThatThrownBy(() -> {
            InputRacingCar.checkName(namesWithSpace);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_NAME_ERROR);
    }

    @Test
    void 이름에_공백이_없을때() {
        List<String> namesValid = List.of("pobi", "jun");
        assertThatCode(() -> {
            InputRacingCar.checkName(namesValid);
        }).doesNotThrowAnyException();
    }
}