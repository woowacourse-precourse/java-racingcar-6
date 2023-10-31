package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RefereeTest {

    private Referee referee;
    @BeforeEach
    void SetUp() {
        referee = new Referee();
    }

    @Test
    void 우승자1명() {
        Map<String, Integer> raceResult = new HashMap<String, Integer>();
        raceResult.put("pobi", 5);
        raceResult.put("woni", 4);
        raceResult.put("jun", 3);
        List<String> result = referee.winner(raceResult);
        String  str = String.join(",",  result);
        assertThat(str).isEqualTo("pobi");
    }

    @Test
    void 우승자2명() {
        Map<String, Integer> raceResult = new HashMap<String, Integer>();
        raceResult.put("pobi", 5);
        raceResult.put("woni", 4);
        raceResult.put("yuki", 5);
        raceResult.put("jun", 3);
        List<String> result = referee.winner(raceResult);
        String  str = String.join(",",  result);
        assertThat(str).isEqualTo("pobi,yuki");
    }

}
