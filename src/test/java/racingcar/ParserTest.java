package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utils.Parser;

public class ParserTest {

    @Test
    void 구분자를_기준으로_문자열을_자르고_앞뒤_공백_없는_문자열_리스트를_반환() {
        String input = "일,   이 , 삼";
        String splitter = ",";
        List<String> expected = List.of("일", "이", "삼");

        assertThat(Parser.splitStringBySplitter(input, splitter)).isEqualTo(expected);
    }

    @Test
    void 숫자가_아닌_값을_입력하면_예외_발생() {
        String input = "문자열";

        assertThatThrownBy(
                () -> Parser.stringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
