package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RegexMatcherTest {

    @Test
    void matchFalse() {
        // given
        String regex = "^[0-9]{1,3}$";

        // when
        String unvalid = "abc";

        // then
        assertThat(RegexMatcher.match(regex, unvalid)).isEqualTo(false);
    }

    @Test
    void matchTrue() {
        // given
        String regex = "^[0-9]{1,3}$";

        // when
        String unvalid = "123";

        // then
        assertThat(RegexMatcher.match(regex, unvalid)).isEqualTo(true);
    }
}