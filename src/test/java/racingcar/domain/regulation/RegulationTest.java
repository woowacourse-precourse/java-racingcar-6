package racingcar.domain.regulation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

class RegulationTest {

    @Test
    void goStop() {
        HashMap<String, Integer> lineUp = new HashMap<>(){{
            put("hi",0);
            put("my",0);
            put("name",0);
            put("is",0);
            put("Hello",0);
            put("world",0);
        }};

        Regulation.goStop(lineUp);

//        Iterable<Integer> expectedValues = Arrays.asList(0, 1);
//        assertThat(lineUp.values()).containsAnyElementsOf(expectedValues);

        boolean allValuesInRange = lineUp.values().stream()
                .allMatch(value -> value >= 0 && value <= 1);

        assertThat(allValuesInRange).isTrue();

    }
}