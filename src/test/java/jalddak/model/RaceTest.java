package jalddak.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;

public class RaceTest {
    Race race;

    @BeforeEach
    void race_초기화() {
        this.race = new Race("HJ,HS,SH", "5");
    }

    @Test
    void getPerMatchResult() {
        Map<String, Integer> expect = new HashMap<>();
        expect.put("HJ", 0);
        expect.put("HS", 0);
        expect.put("SH", 0);

        Map<String, Integer> result = race.getPerMatchResult();
        assertThat(expect).isEqualTo(result);
    }
}
