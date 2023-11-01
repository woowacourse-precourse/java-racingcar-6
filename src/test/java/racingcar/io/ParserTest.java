package racingcar.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {
    private Parser parser;

    @BeforeEach
    void init() {
        this.parser = new Parser();
    }

    @Test
    void testParseCarNames() {
        String[] testCases = {
                "pobi,woni,jun",
                "legacy,mars,common,john",
                "maine",
                ""
        };

        int[] expectedLengths = {
                3,
                4,
                1,
                1
        };

        String[][] expectedArrays = {
                { "pobi", "woni", "jun" },
                { "legacy", "mars", "common", "john" },
                { "maine" },
                { "" }
        };

        for (int i = 0; i < testCases.length; i++) {
            String[] names = this.parser.parseCarNames(testCases[i]);
            assertThat(names.length).isEqualTo(expectedLengths[i]);
            assertThat(names).contains(expectedArrays[i]);
        }
    }

    @Test
    void testParseInt_throwsException() {
        String[] testCases = {
                "123a",
                "a56",
                "b",
                "13!",
                "3.14",
                ""
        };

        for (String testCase : testCases) {
            assertThatThrownBy(() -> this.parser.parseInt(testCase))
                    .isInstanceOf(NumberFormatException.class);
        }
    }

    @Test
    void testParseInt_correct() {
        String[] testCases = {
                "56",
                "0",
                "13",
                "-1",
                "-0"
        };

        int[] expected = {
                56,
                0,
                13,
                -1,
                0
        };

        for (int i = 0; i < testCases.length; i++) {
            assertThat(this.parser.parseInt(testCases[i]))
                    .isEqualTo(expected[i]);
        }
    }
}