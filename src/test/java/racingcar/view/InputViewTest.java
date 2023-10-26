package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    @DisplayName("쉼표(,)를 기준으로 구분 테스트")
    void splitTest() {
        String input = "pobi,woni,jun";
        String[] result = InputView.splitByComma(input);

        assertThat(result).contains("woni", "jun", "pobi");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("구분자가 포함되지 않은 경우 값을 그대로 반환 테스트")
    void splitTest2() {
        String input = "pobi";
        String[] result = InputView.splitByComma(input);

        assertThat(result).contains("pobi");
    }
}