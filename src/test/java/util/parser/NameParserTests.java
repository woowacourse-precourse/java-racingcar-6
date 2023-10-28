package util.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.container.ApplicationContainer.getNameParser;

import racingcar.util.parser.NameParser;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NameParserTests {
    private final NameParser NameParser = getNameParser();

    @Test
    @DisplayName("이름이 없는 경우에도 빈 문자열로 변환된다")
    void test1() {
        // given
        String input = "첫번째,두번째,세번째,,다섯번째";

        // when
        List<String> result = NameParser.parse(input);

        // then
        String[] expect = {"첫번째", "두번째", "세번째", "", "다섯번째"};
        for (int i = 0; i < expect.length; i++)
            assertThat(result.get(i)).isEqualTo(expect[i]);
    }

    @Test
    @DisplayName("마지막 참가자가 이름이 없는 경우에도 빈 문자열로 변환된다")
    void test2() {
        // given
        String input = "첫번째,두번째,세번째,네번째,,";

        // when
        List<String> result = NameParser.parse(input);

        // then
        String[] expect = {"첫번째", "두번째", "세번째", "네번째", "", ""};
        assertThat(result.size()).isEqualTo(6);
        for (int i = 0; i < expect.length; i++)
            assertThat(result.get(i)).isEqualTo(expect[i]);
    }
}
