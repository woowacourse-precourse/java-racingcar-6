package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import racer.Racer;
import racer.Race;

import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    void setRacers_메서드에서_5자이상_예외() {
        Race race = new Race();
        String input = "Alex,Markus";

        assertThrows(IllegalArgumentException.class, () -> {
            race.setRacers(input);
        });
    }

    @Test
    void setRacers_메서드에서_0자_입력_예외() {
        Race race = new Race();
        String input = "Alex,,James";

        assertThrows(IllegalArgumentException.class, () -> {
            race.setRacers(input);
        });
    }

    @Test
    void setRacers_메서드에서_공백_입력_예외() {
        Race race = new Race();
        String input = "Alex, ,James";

        assertThrows(IllegalArgumentException.class, () -> {
            race.setRacers(input);
        });
    }

    @Test
    void setRacers_메서드에서_탭문자_입력_예외() {
        Race race = new Race();
        String input = "Alex,\t,James";

        assertThrows(IllegalArgumentException.class, () -> {
            race.setRacers(input);
        });
    }

}
