package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {


    @DisplayName("parseToList 메서드 테스트")
    @Test
    void parseToListTest() {
        String input = "pobi,woni,jun";
        List<String> result = StringParser.parseToList(input);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }
}