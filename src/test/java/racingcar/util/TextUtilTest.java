package racingcar.util;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.util.TextUtil.*;

class TextUtilTest {

    @Test
    void 문자열_공백_제거_및_분리_검증() {
        String target = "  car1 , ca r2,car3  ,car4   ";
        List<String> expected = List.of("car1", "ca r2", "car3", "car4");

        assertThat(splitAndTrim(target, ",")).isEqualTo(expected);
    }

    @Test
    void 문자수_초과_검증() {
        int maxLength = 5;
        String OverTarget = "123456";
        String notOverTarget = "1234";

        assertThat(isOverLength(OverTarget, maxLength)).isTrue();
        assertThat(isOverLength(notOverTarget, maxLength)).isFalse();
    }

    @Test
    void 중복_문자_검증() {
        List<String> notDuplicationList = List.of("jon", "piter", "grace");
        List<String> duplicationList = List.of("jon", "piter", "piter");

        assertThat(hasDuplicates(notDuplicationList)).isFalse();
        assertThat(hasDuplicates(duplicationList)).isTrue();
    }

    @Test
    void 문자열_콤마_결합_검증() {
        List<String> targetList = List.of("car1", "car2", "car3");
        String expected = "car1, car2, car3";
        assertThat(joinListWithComma(targetList)).isEqualTo(expected);
    }
}