package racingcar.domain.console.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputParserTest {

    private final InputParser inputParser = InputParser.newInstance();

    @Test
    void 입력문자열을_숫자로_변환하는_테스트() {
        // given
        final String INPUT_NUMBER = "3";
        final int EXPECTED_NUMBER = 3;
        // when
        final int NUMBER = inputParser.parseInt(INPUT_NUMBER);

        // then
        assertThat(NUMBER)
                .isEqualTo(EXPECTED_NUMBER);
    }

    @Test
    void 입력문자열_구분자로_분리_테스트() {
        // given
        final String INPUT_NAMES = "pobi,woni,jun";
        final String[] EXPECTED_NAMES = {"pobi", "woni", "jun"};

        final String SPLIT_REGEX = ",";
        // when
        final String[] NAMES = inputParser.parseUserNames(INPUT_NAMES, SPLIT_REGEX);

        // then
        for (int i = 0; i < NAMES.length; i++) {
            assertThat(NAMES[i])
                    .isEqualTo(EXPECTED_NAMES[i]);
        }

    }
}