package jalddak.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;

public class RaceTest {
    Race race;

    @Test
    void getPerMatchResult() {
        //given
        this.race = new Race(new String[]{"HJ", "HS", "SH"}, new int[]{5, 9, 4}, 3);
        Map<String, Integer> expect = new HashMap<>();
        expect.put("HJ", 5);
        expect.put("HS", 9);
        expect.put("SH", 4);

        //when
        Map<String, Integer> result = race.getPerMatchResult();

        //then
        assertThat(expect).isEqualTo(result);
    }

    @Test
    void checkMaxDistance() {
        //given
        this.race = new Race(new String[]{"HJ", "HS", "SH"}, new int[]{5, 9, 4}, 3);
        int expect = 9;

        //when
        int result = race.checkMaxDistance();

        //then
        assertThat(expect).isEqualTo(result);
    }

    @Test
    void getWinner() {
        //given
        this.race = new Race(new String[]{"HJ", "HS", "SH", "WAK", "HAN", "GOOD"}
                , new int[]{5, 9, 4, 33, 26, 33}, 6);
        List<String> expect = new ArrayList<>();
        expect.add("WAK");
        expect.add("GOOD");

        //when
        List<String> result = race.getWinner();

        //then
        assertThat(expect).isEqualTo(result);
    }
}
