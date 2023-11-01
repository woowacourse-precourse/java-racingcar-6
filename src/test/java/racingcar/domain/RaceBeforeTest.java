package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.entry;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RaceBeforeTest {
    private RaceBefore raceBefore;
    @BeforeEach
    void setUp() {
        raceBefore = new RaceBefore();
    }

    @Test
    void 자동차이름입력() {
        //given
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        Map<String, Integer> carTest = raceBefore.carName();

        //then
        assertThat(carTest).containsExactly(entry("pobi", 0), entry("woni", 0), entry("jun", 0));
    }

    @Test
    void 잘못된이름입력() {
        //given
        String input = "lefthand,pobi";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            raceBefore.carName();
        });
    }
}
