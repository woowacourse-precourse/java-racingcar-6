package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SeparatorTest {

    private static final int CHICKEN = 0;
    private static final int PIZZA = 1;
    private static final int SUSHI = 2;

    @Test
    @DisplayName("쉼표를 기준으로 문자열을 나누고 이를 문자열 리스트로 반환한다.")
    void should_SeparateByComma_When_DelimeterIsComma() {
        List<String> result = Separator.separateByDelimeter("치킨,피자,스시");
        assertThat(result.get(CHICKEN)).isEqualTo("치킨");
        assertThat(result.get(PIZZA)).isEqualTo("피자");
        assertThat(result.get(SUSHI)).isEqualTo("스시");
    }
}
