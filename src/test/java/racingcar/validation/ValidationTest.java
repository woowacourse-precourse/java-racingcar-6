package racingcar.validation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    @Test
    void vaildCount_메서드_사용시_숫자가_아닌_문자가_찾았을_때_예외_발생() {
        String input = "1,2";

        assertThatThrownBy(() -> Validation.validCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void vaildNames_메서드_사용시_연속된_쉼표_문자_사용을_찾았을_때_예외_발생() {
        String input = "1,,2";

        assertThatThrownBy(() -> Validation.validNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void vaildNames_메서드_사용시_구분된_문자열의_길이가_특정_길이보다_길_때_예외_발생() {
        String input = "1,2a234f";

        assertThatThrownBy(() -> Validation.validNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void vaildNames_메서드_사용시_구분된_문자열이_공백일_때_예외_발생() {
        String input = "1,  ,3";

        assertThatThrownBy(() -> Validation.validNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
