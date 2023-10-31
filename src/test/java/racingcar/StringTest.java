package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("쉼표를 사용해 여러개의 차를 입력하는 경우 확인")
    public void inputCarNames_withSeperator() {
        String input = "pobi,woni";
        String[] result = input.split(",");
        assertThat(result).containsExactly("pobi", "woni");
    }
}
