package racingcar.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
            Assertions.assertThat(names.length).isEqualTo(expectedLengths[i]);
            Assertions.assertThat(names).contains(expectedArrays[i]);
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
            Assertions.assertThatThrownBy(() -> this.parser.parseInt(testCase))
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
            Assertions.assertThat(this.parser.parseInt(testCases[i]))
                    .isEqualTo(expected[i]);
        }
    }
}