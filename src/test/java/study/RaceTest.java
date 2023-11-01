package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceTest {
    @Test
    void max_메서드에서_최대값_찾기() {
        HashMap<String, Integer> carDist = new HashMap<>();
        carDist.put("a",0);
        carDist.put("b",1);
        carDist.put("c",2);
        int maxValue = Collections.max(carDist.values());

        assertThat(maxValue).isEqualTo(2);
    }
    @Test
    void findMaxValueKeys_메서드에서_최대값을_가진_키값_찾기() {
        HashMap<String, Integer> carDist = new HashMap<>();
        int maxValue = 5;
        carDist.put("pobi", 5);
        carDist.put("woni", 3);
        carDist.put("jun", 5);

        List<String> maxValueKeys = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : carDist.entrySet()) {
            if (entry.getValue() == maxValue) {
                maxValueKeys.add(entry.getKey());
            }
        }

        assertThat(maxValueKeys).containsExactlyInAnyOrder("pobi", "jun");
    }

}
