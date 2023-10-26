package racingcar;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.Application.getAnswer;

public class UnitTest {
    @Test
    void test_get_answer() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("car1", 5);
        map.put("car2", 3);
        map.put("car3", 5);

        String result = getAnswer(map);
        assertThat(result).isEqualTo("최종 우승자 : car1, car3");
    }
}
