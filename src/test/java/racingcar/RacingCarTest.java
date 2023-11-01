package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RacingCarTest {

    @Test
    void 구분자와_공백을_제거한_문자열_반환() {
        List<String> splitInput;
        List<String> splitInput2;

        String input = "  nameWithSpace   ,  nameWithSpace2, nameWithSpace3";
        String input2 = "noSeparator";

        splitInput = Arrays.stream(input.replaceAll(" ", "").split(",")).toList();
        splitInput2 = Arrays.stream(input2.replaceAll(" ", "").split(",")).toList();

        assertThat(splitInput).containsExactly("nameWithSpace", "nameWithSpace2", "nameWithSpace3");
        assertThat(splitInput2).containsExactly("noSeparator");
    }

    @Test
    void 숫자가_아닐_경우_예외_발생() {
        String input2 = "abc";

        assertThatThrownBy(() -> Integer.parseInt(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다섯_글자가_넘는_문자열인지_검사() {
        String longLengthString = "this string is very long";

        assertThat(longLengthString.length() > 5).isEqualTo(true);
    }

    @Test
    void 빈_문자열인지_검사() {
        String emptyString = "";

        assertThat(emptyString).isEmpty();
    }

    @Test
    void 영어를_제외한_다른_문자가_들어갔는지_검사() {
        String mixName = "한글숫자123영어abc";
        String pattern = "[a-zA-Z0-9]*";

        assertThat(!mixName.matches(pattern)).isEqualTo(true);
    }
}
