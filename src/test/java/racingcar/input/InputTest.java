package racingcar.input;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.UserInputManager;

public class InputTest {
    @BeforeEach
    void close() {
        Console.close();
    }
    @Test
    void 시도_회수_입력받기() {
        String input = "3";
        setInput(input);

        int turn = UserInputManager.inputNumberOfAttempts();

        assertThat(turn).isEqualTo(3);
    }

    @Test
    void 시도_회수에_잘못된_입력() {
        String input = "asdf";
        setInput(input);

        assertThatThrownBy(() -> UserInputManager.inputNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해야 합니다.");
    }

    @Test
    void 시도_회수에_공백_자동_제거() {
        String input = " 33  ";
        setInput(input);

        int turn = UserInputManager.inputNumberOfAttempts();

        assertThat(turn).isEqualTo(33);
    }

    @Test
    void 이름_입력_자르기() {
        String input = "pobi,woni,jun";
        setInput(input);

        List<String> names = UserInputManager.inputCarName();

        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 이름_길이_예외_발생() {
        String input = "pobi,unyong";
        setInput(input);

        assertThatThrownBy(() -> UserInputManager.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1-5글자 사이로 입력해야 합니다.");
    }

    @Test
    void 한_개의_이름만_있는_경우() {
        String input = "pobi";
        setInput(input);

        List<String> names = UserInputManager.inputCarName();

        assertThat(names).containsExactly("pobi");
    }

    @Test
    void 공백_자동_제거() {
        String input = " pobi ,wo ni, ju n ";
        setInput(input);

        List<String> names = UserInputManager.inputCarName();

        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    void setInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
