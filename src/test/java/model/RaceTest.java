package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;

public class RaceTest {

    @Test
    void names_개수_만큼_생성되는지_확인() {
        Race race1 = new Race(Arrays.asList("pobi", "woni", "jun"));
        Race race2 = new Race(Arrays.asList("pobi", "woni", "jun", "lee", "sun"));

        assertThat(race1.getCarSize()).isEqualTo(3);
        assertThat(race2.getCarSize()).isEqualTo(5);
    }
}
