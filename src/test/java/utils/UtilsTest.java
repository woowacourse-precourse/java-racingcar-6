package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    public void split_구분자를_이용하여_문자열_분리() {
        String input = "pobi,jun,woni";
        String[] expectString = {"pobi", "jun", "woni"};

        assertThat(Utils.splitByDelimiter(input,",")).isEqualTo(expectString);
    }

    @Test
    public void split_구분자가_없을_때_문자열_그대로를_반환() {
        String input = "pobi";
        String[] expectString = {"pobi"};

        assertThat(Utils.splitByDelimiter(input,",")).isEqualTo(expectString);
    }
}
