package racingcar.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {
    @Test
    void 자동차명_쉼표공백처리_테스트() {
        List<String> result = Parser.parseCarNames("hot, fried, chicken");

        assertThat(result).contains("chicken", "hot", "fried");
        assertThat(result).containsExactly("hot", "fried", "chicken");
    }

    @Test
    void 자동차명_0글자_테스트() {
        List<String> result = Parser.parseCarNames("hot,  , fried");

        assertThat(result).contains("hot", "", "fried");
        assertThat(result).containsExactly("hot", "", "fried");
    }

    @Test
    void 자동차명_쉼표로끝났을때_테스트() {
        List<String> result = Parser.parseCarNames("hot,");

        assertThat(result).contains("hot", "");
        assertThat(result).containsExactly("hot", "");
    }
}