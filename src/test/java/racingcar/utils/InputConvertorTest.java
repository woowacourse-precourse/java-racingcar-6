package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConvertorTest {
    String inputNames = "pobi,woni,jun";

    @Test
    @DisplayName("컴마로 구분된 값을 분리한다.")
    void separateInputToNamesTest() {
        String[] result = InputConvertor.separateInputToNames(inputNames);

        assertThat(result).containsExactly("pobi", "woni", "jun");
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    @DisplayName("빈칸이 포함된 컴마로 구분된 값을 분리한다.")
    void separateInputToNamesWithSpaceTest() {
        String[] result = InputConvertor.separateInputToNames(inputNames);

        assertThat(result).containsExactly("pobi", "woni", "jun");
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    @DisplayName("최대 길이보다 큰 이름을 입력 시 예외를 발생한다.")
    void separateInputToNamesMoreThanLimitTest() {
        String inputNameLengthMoreThanFive = "pobipobipobi, woni, jun";

        assertThatThrownBy(() -> InputConvertor.separateInputToNames(inputNameLengthMoreThanFive))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 제한 길이를 초과했습니다.");
    }

    @Test
    @DisplayName("중복된 이름이 입력으로 들어올 경우, 예외를 발생한다.")
    void duplicationInputTest() {
        String inputNameDuplicated = "pobi, woni, pobi";

        assertThatThrownBy(() -> InputConvertor.separateInputToNames(inputNameDuplicated))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 중복은 허용하지 않습니다.");
    }

    @Test
    @DisplayName("시도 횟수 입력 시, int로 변환한다.")
    void parseTryCountTest() {
        String inputTry = "12";
        int result = InputConvertor.parseTryCount(inputTry);

        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("정수가 아닌 시도 횟수 입력 시, 예외를 발생한다.")
    void parseTryCountNotIntegerTest() {
        String inputTry = "12.5";

        assertThatThrownBy(() -> InputConvertor.parseTryCount(inputTry))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("0보다 작은 시도 횟수 입력 시, 예외를 발생한다.")
    void validateTryCountTest() {
        int inputTry = 0;

        assertThatThrownBy(() -> InputConvertor.isTryCountNaturalNumber(inputTry))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }
}