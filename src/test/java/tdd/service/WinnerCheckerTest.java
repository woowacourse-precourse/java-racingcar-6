package tdd.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;


public class WinnerCheckerTest {
    @Test
    void 예상되는_우승자_반환시_통과() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Car1", 1);
        map.put("Car2", 1);
        map.put("Car3", 5);
        map.put("Car4", 4);

        assertThat(WinnerChecker.checkWinner(map).get(0)).isEqualTo("Car3");
    }
}
