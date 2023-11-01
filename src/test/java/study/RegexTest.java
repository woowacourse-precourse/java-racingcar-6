package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegexTest {

    @Test
    void 완전히_일치_불일치() {
        // given
        String input = "129A";
        Pattern pattern = Pattern.compile("[1-9]+\\d*");
        // when
        Matcher matcher = pattern.matcher(input);
        // then
        Assertions.assertFalse(matcher.matches());
    }

    @Test
    void 완전히_일치_일치() {
        // given
        String input = "1209";
        Pattern pattern = Pattern.compile("[1-9]+\\d*");
        // when
        Matcher matcher = pattern.matcher(input);
        // then
        Assertions.assertTrue(matcher.matches());
    }

    @Test
    void 일치하는_패턴_추출_전화번호() {
        // given
        String input = "abcd010-1234-5678(*)&*";
        Pattern pattern = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
        // when
        Matcher matcher = pattern.matcher(input);
        // then
        if (matcher.find()) {
            String extractedString = input.substring(matcher.start(), matcher.end());
            assertThat(extractedString).isEqualTo("010-1234-5678");
        } else {
            Assertions.fail();
        }
    }
}
