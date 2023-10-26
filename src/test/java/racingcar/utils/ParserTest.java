package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 자동차명_쉼표공백테스트() {
        //hot fried는 쉼표, fried chicken은 쉼표+공백
        List<String> result = Parser.parseCarsName("hot,fried, chicken");
        assertThat(result).contains("chicken", "hot", "fried");
        assertThat(result).containsExactly("hot", "fried", "chicken");

    }
}