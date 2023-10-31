package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.paser.InputCarNameParser;

class ParserTest {

    @DisplayName("자동차의 이름을 ',' 로 파싱하는 parsing()는 List<String>을 반환한다.")
    @Test
    void parsing() {
        InputCarNameParser parser = new InputCarNameParser();
        String target = "pobi,woni,jun";
        List<String> parsing = parser.parsing(target);

        assertThat(parsing).containsExactlyInAnyOrderElementsOf(Arrays.asList("pobi", "woni", "jun"));
    }
}