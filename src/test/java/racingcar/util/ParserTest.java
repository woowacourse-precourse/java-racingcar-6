package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utils.Parser;

public class ParserTest {
    @Test
    public void 파서_테스트() {
        String carNames = "a,b,c";
        List<String> result = Parser.parseWithComma(carNames);
        assertThat(result).contains("a");
        assertThat(result).contains("b");
        assertThat(result).contains("c");
    }
}
