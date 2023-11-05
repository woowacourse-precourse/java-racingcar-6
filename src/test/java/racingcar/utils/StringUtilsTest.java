package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    @DisplayName("countOccurrences 메서드가 문자열에서 특정 문자열(1글자)이 몇 번 등장하는지 정확하게 반환한다.")
    void countOccurrencesCountTargetStringWhenTargetStringLengthIsOne() {
        String testString = "AABABC";

        String targetSTring = "A";

        int result = StringUtils.countOccurrences(testString, targetSTring);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("countOccurrences 메서드가 문자열에서 특정 문자열(2글자)이 몇 번 등장하는지 정확하게 반환한다.")
    void countOccurrencesCountTargetStringWhenTargetStringLengthIsTwo() {
        String testString = "AABABC";

        String targetSTring = "AB";

        int result = StringUtils.countOccurrences(testString, targetSTring);

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("countOccurrences 메서드가 문자열에서 특정 문자열(3글자)이 몇 번 등장하는지 정확하게 반환한다.")
    void countOccurrencesCountTargetStringWhenTargetStringLengthIsThree() {
        String testString = "AABABC";

        String targetSTring = "ABC";

        int result = StringUtils.countOccurrences(testString, targetSTring);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("countOccurrences 메서드로 대상 문자열에 존재하지 않은 문자열 검색 시 0을 반환한다.")
    void countOccurrencesReturnZeroWhenTargetStringDoNotExistInTestString() {
        String testString = "AABABC";

        String targetSTring = "D";

        int result = StringUtils.countOccurrences(testString, targetSTring);

        assertThat(result).isEqualTo(0);
    }
}