package game;

import org.junit.jupiter.api.Test;
import racingcar.InputValidator;
import racingcar.RaceGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {
    InputValidator validator = new InputValidator();
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
        List<String> input = new ArrayList<>();
        input.add("123");
        input.add("12345");
        input.add("123456");

        assertThrows(IllegalArgumentException.class, () -> validator.checkNameLength(input));
    }

    @Test
    void 입력값_띄어쓰기_예외_확인(){
        String input = "1 ,2,3";

        assertThrows(IllegalArgumentException.class, () -> validator.checkInputForSpaces(input));
    }

    @Test
    void 입력값_Empty_예외(){
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> validator.checkInputEmpty(input));
    }
}
