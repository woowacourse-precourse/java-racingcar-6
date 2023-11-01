package racingcar.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static racingcar.fixture.NameFixture.VALID_NAME_1;
import static racingcar.fixture.NameFixture.VALID_NAME_2;

@DisplayName("[Parser Test] - Domain Layer")
class ParserTest {

    @Nested
    @DisplayName("[parseCarNames] input을 Delemiter 단위로 나누어, List<String> 형태로 반환한다.")
    class parseCarNamesTest {

        @Test
        @DisplayName("[Success] 정상적인 조건의 이름들로, 파싱에 성공한다.")
        void Given_ValidNames_When_ParseCarNames_Then_ReturnParsedList() {
            // given
            final String DELIMITER = ",";
            final String NAMES_INPUT = String.format("%s%s%s", VALID_NAME_1.getName(), DELIMITER, VALID_NAME_2.getName());
            final List<String> EXPECTED_NAMES_OUTPUT = List.of(VALID_NAME_1.getName(), VALID_NAME_2.getName());

            // when
            List<String> strings = Parser.parseCarNames(NAMES_INPUT);

            // then
            Assertions.assertThat(strings).isEqualTo(EXPECTED_NAMES_OUTPUT);
        }
    }

    @Nested
    @DisplayName("[parseRoundCount] input을 Integer형으로 파싱하여 반환한다.")
    class parseRoundCountTest {

        @Test
        @DisplayName("[Success] 정상적인 조건의 숫자형 문자로, 파싱에 성공한다.")
        void Given_ValidRoundCount_When_ParseRoundCount_Then_ParsedRoundCount() {
            // given
            final String INPUT = "3";
            final int EXPECTED_OUTPUT = 3;

            // when
            int result = Parser.parseRoundCount(INPUT);

            // then
            Assertions.assertThat(result).isEqualTo(EXPECTED_OUTPUT);
        }
    }
}
