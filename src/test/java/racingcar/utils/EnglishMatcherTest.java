package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EnglishMatcherTest {

    @Test
    @DisplayName("영어 문자열인지 확인")
    void isEnglish() {
        // given
        String english = "abc";

        // when
        boolean isEnglish = EnglishMatcher.isEnglish(english);

        // then
        assertTrue(isEnglish);
    }

    @Test
    @DisplayName("영어 문자열이 아닌지 확인")
    void isNotEnglish() {
        // given
        String notEnglish = "가나다";

        // when
        boolean isEnglish = EnglishMatcher.isEnglish(notEnglish);

        // then
        assertFalse(isEnglish);
    }
}