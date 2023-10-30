package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ScreenTest {

    @Test
    void 자동차_이름_입력() {
        String input = "pobi,yen,joy,red";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] result = Screen.askCarNames();

        assertThat(result).hasSize(4);
        assertThat(result).containsExactly("pobi", "yen", "joy", "red");
    }

    @Test
    void 길이_5이상의_자동차_이름_입력() {
        String input = "computer,yen,joy,red";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(Screen::askCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이_0인_자동차_이름_입력() {
        String input = ",yen,joy,red";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(Screen::askCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주_시행_횟수_입력() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = Screen.askRacingTime();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 경주_시행_횟수_숫자가_아닌_문자열_입력() {
        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(Screen::askRacingTime)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
