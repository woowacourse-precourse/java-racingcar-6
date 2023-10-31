package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarNameUtilTest {

    @Test
    void 자동차_이름_입력값을_리스트로_변환하는지_테스트() {
        List<String> nameList = CarNameUtil.parseNamesToList("A,B,C");
        assertThat(nameList).containsExactly("A", "B", "C");
    }
}
