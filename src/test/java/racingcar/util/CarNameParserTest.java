package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CarNameParserTest {

    private static final String INVALID_INPUT_MESSAGE = "자동차 이름은 쉼표(,) 기준으로 구분하여 입력해야 합니다.";

    @Test
    void 주어진_값을_쉼표로_구분하여_리스트로_반환() {
        String input = "pobi,woni,jun";
        List<String> result = CarNameParser.parse(input);

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }
    @Test
    void 연속된_쉼표_포함시_예외_발생() {
        String input = "pobi,,woni";

        assertThatThrownBy(() -> CarNameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_INPUT_MESSAGE);
    }

    @Test
    void 잘못된_구분자_포함시_예외_발생() {
        String input = "pobi!woni!jun";

        assertThatThrownBy(() -> CarNameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_INPUT_MESSAGE);
    }
}
