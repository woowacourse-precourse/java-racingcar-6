package racingcar.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {
    private static final String BEFORE_PARSING = "pobi,woni,jun";

    @Test
    void getParsed메소드로_매겨변수를_parsing해서_리스트_반환() {
        //given

        //when
        List<String> parsed = InputParser.parseCarNames(BEFORE_PARSING);

        //then
        List<String> expected = List.of("pobi", "woni", "jun");
        assertThat(parsed).isEqualTo(expected);
    }
}