package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

public class StringUtilsTest {

    @Test
    void testStringToIntWithValidInput() {
        int result = StringUtils.stringToInt("42");
        assertThat(result).isEqualTo(42);
    }
    @Test
    void testSplitByComma() {
        String[] result = StringUtils.splitByComma("apple,banana,cherry");
        assertThat(result).isEqualTo(new String[]{"apple", "banana", "cherry"});
    }

    @Test
    void testRepeatString() {
        String result = StringUtils.repeatString("abc", 3);
        assertThat(result).isEqualTo("abcabcabc");
    }

    @Test
    void testJoinWithCommas() {
        List<String> elements = Arrays.asList("one", "two", "three");
        StringBuilder result = StringUtils.joinWithCommas(elements);

        assertThat(result.toString()).isEqualTo("one, two, three");
    }
}
