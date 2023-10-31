package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RaceControllerTest {

    private RaceController race;

    @BeforeEach
    void setUp() {
        race = new RaceController();
    }

    @Test
    void 자동차_이름_입력() {
        String input = "young,son,kane";
        String[] racingCarList = race.ready(input);
        assertThat(racingCarList[1]).isEqualTo("son");
    }

    @Test
    void 최소_2대_이상의_자동차를_입력하지_않은_경우() {
        String input = "young";
        assertThrows(IllegalArgumentException.class, () -> {
            race.ready(input);
        });
    }

    @Test
    void 자동차_이름이_없는_경우_콤마_앞() {
        String input = ",young,son";
        assertThrows(IllegalArgumentException.class, () -> {
            race.ready(input);
        });
    }

    @Test
    void 자동차_이름이_없는_경우_콤마_뒤() {
        String input = "young,son,";
        assertThrows(IllegalArgumentException.class, () -> {
            race.ready(input);
        });
    }

    @Test
    void 자동차_이름이_없는_경우_콤마_사이() {
        String input = "young,,son";
        assertThrows(IllegalArgumentException.class, () -> {
            race.ready(input);
        });
    }

    @Test
    void 자동차_이름_길이_제한을_벗어났을_경우() {
        String input = "young,son,justin";
        assertThrows(IllegalArgumentException.class, () -> {
            race.ready(input);
        });
    }
}