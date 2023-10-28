package game;

import org.junit.jupiter.api.Test;
import racingcar.InputValidator;
import racingcar.GameInputHandler;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {
    InputValidator validator = new InputValidator();
    @Test
    void split_메서드로_주어진_값을_구분() {
        GameInputHandler gameInputHandler = new GameInputHandler();
        String input = "1,2";
        List<String> cars = gameInputHandler.splitStringToList(input);

        assertThat(cars).contains("2", "1");
        assertThat(cars).containsExactly("1", "2");
    }

    @Test
    void 이름에_대한_예외_처리() {
        List<String> input = new ArrayList<>();
        input.add("123");
        input.add("12345");
        input.add("123456");

        assertThrows(IllegalArgumentException.class, () -> validator.checkCarsName(input));
    }

    @Test
    void 입력값_띄어쓰기_예외_확인(){
        String input = "1 ,2,3";

        assertThrows(IllegalArgumentException.class, () -> validator.checkInputValue(input));
    }

    @Test
    void 입력값_Empty_예외(){
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> validator.checkInputValue(input));
    }

    @Test
    void 자동차_이름_중복(){
        List<String> input = new ArrayList<>();
        input.add("abc");
        input.add("def");
        input.add("abc");

        assertThrows(IllegalArgumentException.class, () -> validator.checkCarsName(input));
    }

    @Test
    void 시도할_횟수_숫자_외_값(){
        String input = "a";

        assertThrows(IllegalArgumentException.class, () -> validator.checkEttempts(input));
    }
}
