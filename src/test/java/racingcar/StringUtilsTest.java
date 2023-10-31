package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.StringUtils;

public class StringUtilsTest {
    final StringUtils stringUtils = new StringUtils();

    @Test
    void separateAndRemoveSpace_메서드로_자동차_이름_구분() {
        String input = "a , b, c ";
        List<String> result = Arrays.asList("a", "b", "c");
        assertThat(stringUtils.separateAndRemoveSpace(input)).isEqualTo(result);
    }
}
