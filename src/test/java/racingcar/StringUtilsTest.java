package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.StringUtils;

public class StringUtilsTest {
    final StringUtils stringUtils = new StringUtils();

    @DisplayName("자동차는 쉼표를 기준으로 구분하고 공백을 제거하여 생성된다")
    @Test
    void separateAndRemoveSpace() {
        String input = "a , b, c ";
        List<String> result = Arrays.asList("a", "b", "c");
        assertThat(stringUtils.separateAndRemoveSpace(input)).isEqualTo(result);
    }

    @DisplayName("최종 우승자는 쉼표로 구분하여 출력된다")
    @Test
    void joinWinners(){
        List<String> winners = Arrays.asList("pobi", "jun");
        String result = "pobi, jun";
        assertThat(result).isEqualTo(stringUtils.join(winners));
    }
}
