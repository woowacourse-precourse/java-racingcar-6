package racingcar.utils;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StringGeneratorTest {
    @Test
    void 자동차_이름_생성(){
        List<String> carNames = StringGenerator.generateCarName("pobi,woni", ",");
        assertThat(carNames.get(0)).isEqualTo("pobi");
    }

}