package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @DisplayName("구분자를 기반으로 올바르게 토큰화한다")
    @Test
    void parseToListTest() {
        String input = "pobi,woni,jun";
        List<String> result = StringParser.parseToList(input);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }
}