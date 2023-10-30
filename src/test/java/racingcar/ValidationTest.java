package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationTest {
    Validation validation = new Validation();

    @Test
    void isNotEmpty() {
        List<String> carNamesTrue = List.of("a", "b", "c");
        List<String> carNamesBlank = List.of("a", "");
        List<String> carNamesEmpty = List.of();

        assertThat(validation.isNotEmpty(carNamesTrue)).isTrue();
        assertThatThrownBy(() -> validation.isNotEmpty(carNamesBlank))
                .hasMessage("이름이 없는 자동차가 있습니다.");
        assertThatThrownBy(() -> validation.isNotEmpty(carNamesEmpty))
                .hasMessage("이름을 입력해주세요.");

    }

    @Test
    void isNotRepeated() {
        List<String> carNamesTrue = List.of("a", "b", "c");
        List<String> carNamesRepeated = List.of("a", "a");

        assertThat(validation.isNotRepeated(carNamesTrue)).isTrue();
        assertThatThrownBy(() -> validation.isNotRepeated(carNamesRepeated))
                .hasMessage("중복되는 이름이 있습니다.");
    }

    @Test
    void isLessThanSix() {
        List<String> carNamesTrue = List.of("a", "b", "c");
        List<String> carNamesOverFive = List.of("a", "b", "cdefgh");

        assertThat(validation.isLessThanSix(carNamesTrue)).isTrue();
        assertThatThrownBy(() -> validation.isLessThanSix(carNamesOverFive))
                .hasMessage("5글자 이하로 입력해주세요.");
    }


    @Test
    void isValidNumber() {
        String numberTrue = "1";
        String negativeNum = "-1";
        String notInt = "0.3";

        assertThat(validation.isValidNumber(numberTrue)).isTrue();
        assertThatThrownBy(() -> validation.isValidNumber(negativeNum))
                .hasMessage("양수를 입력해주세요.");
        assertThatThrownBy(() -> validation.isValidNumber(notInt))
                .hasMessage("정수를 입력해주세요.");
    }
}