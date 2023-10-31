package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.view.CarRaceView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRaceTest {

    @Test
    void splitCarNames() {
        String input = "car1,car2";
        CarRaceView view = new CarRaceView();
        List<String> carNames = view.splitCarNames(input);
        assertThat(carNames).contains("car2", "car1");
        assertThat(carNames).containsExactly("car1", "car2");
    }

    @Test
    void validateCarNames() {
        String input = "car12345";
        CarRaceView view = new CarRaceView();
        assertThatThrownBy(() -> view.splitCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
