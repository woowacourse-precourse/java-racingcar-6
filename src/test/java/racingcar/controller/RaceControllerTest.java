package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RaceControllerTest {

    private RaceController race;

    @BeforeEach
    void setUp() {
        race = new RaceController();
    }

    @Test
    void 자동차_이름_입력() {
        String input = "justin,son,kane";
        String[] racingCars = race.ready(input);
        assertThat(racingCars[1]).isEqualTo("son");
    }
}