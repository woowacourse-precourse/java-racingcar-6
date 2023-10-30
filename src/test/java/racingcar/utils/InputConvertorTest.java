package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputConvertorTest {
    String inputNames = "pobi,woni,jun";

    @Test
    void separateInputToNames_컴마로_구분된값_분리() {
        String[] result = InputConvertor.separateInputToNames(inputNames);

        assertThat(result).containsExactly("pobi", "woni", "jun");
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    void separateInputToNames_컴마와_빈칸으로_구분된값_분리() {
        String[] result = InputConvertor.separateInputToNames(inputNames);

        assertThat(result).containsExactly("pobi", "woni", "jun");
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    void separateInputToNames_메서드_사용시_최대길이보다_큰_이름을_찾을_때_예외_발생() {
        String inputNameLengthMoreThanFive = "pobipobipobi, woni, jun";

        assertThatThrownBy(() -> InputConvertor.separateInputToNames(inputNameLengthMoreThanFive))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 제한 길이를 초과했습니다.");
    }

    @Test
    void parseTryCount_입력횟수를_int로_변환() {
        String inputTry = "12";
        int result = InputConvertor.parseTryCount(inputTry);

        assertThat(result).isEqualTo(12);
    }

    @Test
    void parseTryCount_메서드_사용시_소수_변환_예외_발생() {
        String inputTry = "12.5";

        assertThatThrownBy(() -> InputConvertor.parseTryCount(inputTry))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자를 입력해주세요.");
    }

    @Test
    void validateTryCount_메서드_사용시_음수_또는_0_변환_예외_발생() {
        int inputTry = 0;

        assertThatThrownBy(() -> InputConvertor.validateTryCount(inputTry))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }
}