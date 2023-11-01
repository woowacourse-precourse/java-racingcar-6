package racingcar;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultStringBuilderTest {

    ResultStringBuilder resultStringBuilder = new ResultStringBuilder();

    @Test
    void stringBuild_레이스_결과를_문자열로_반환() {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("test1", 1);
        result.put("test2", 3);
        result.put("test3", 2);

        String expectedResult = "test1 : -\ntest2 : ---\ntest3 : --\n";
        assertThat(resultStringBuilder.stringBuild(result)).isEqualTo(expectedResult);
    }
}