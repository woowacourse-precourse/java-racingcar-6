package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class OutputCarNameTest {

    @Test
    void outputPoint_메서드_테스트() {
        List<String> carNameList = Arrays.asList("test");
        Map<String, Integer> point = new HashMap<>();
        point.put("test", 3);
        String output = "---";
        OutputCarName outputCarName = new OutputCarName(carNameList, point);

        assertThat(outputCarName.outputPoint(0)).isEqualTo(output);

    }
}
