package game;

import org.junit.jupiter.api.Test;
import racingcar.InputValidator;
import racingcar.RaceGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {
    @Test
    void split_메서드로_주어진_값을_구분() {
        RaceGame raceGame = new RaceGame();
        String input = "1,2";
        List<String> cars = raceGame.splitStringToList(input);

        assertThat(cars).contains("2", "1");
        assertThat(cars).containsExactly("1", "2");
    }

    @Test
    void 이름에_대한_예외_처리() {
        InputValidator validator = new InputValidator();

        List<String> test = new ArrayList<>();
        test.add("123");
        test.add("12345");
        test.add("123456");

        assertThrows(IllegalArgumentException.class, () -> validator.checkNameLength(test));
    }
}
