package racingcar.Utility;

import static org.assertj.core.api.Assertions.assertThat;

import Utility.StringModifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringModifierTest {
}

@Nested
@DisplayName("자동차 이름을 입력받았을 때 쉼표를 기준으로 이름을 분리해야 합니다.")
class StringSeparatorTest {
    @Test
    void 문자열을_쉼표_구분자로_분리() {

        String input = "pobi,woni,jun";

        String[] result = StringModifier.getInstance().separateCarNamesBySeparator(input, ",");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 문자열을_쉼표가_없다면_그대로_반환() {

        String input = "pojun";

        String[] result = StringModifier.getInstance().separateCarNamesBySeparator(input, ",");
        assertThat(result).containsExactly("pojun");
    }

}
