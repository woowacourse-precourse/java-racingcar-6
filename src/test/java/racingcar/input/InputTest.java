package racingcar.input;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.UserInputManager;

public class InputTest {

    @Test
    void 이름_입력_자르기() {
        String input = "pobi,woni,jun";
        setInput(input);

        List<String> names = UserInputManager.inputCarName();

        assertThat(names).containsExactly("pobi", "woni", "jun");
        Console.close();
    }

    @Test
    void 이름_길이_예외_발생() {
        String input = "pobi,unyong";
        setInput(input);

        assertThatThrownBy(() -> UserInputManager.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1-5글자 사이로 입력해야 합니다.");

        Console.close();
    }

    @Test
    void 한_개의_이름만_있는_경우() {
        String input = "pobi";
        setInput(input);

        List<String> names = UserInputManager.inputCarName();

        assertThat(names).containsExactly("pobi");

        Console.close();
    }

    @Test
    void 공백_자동_제거() {
        String input = " pobi ,wo ni, ju n ";
        setInput(input);

        List<String> names = UserInputManager.inputCarName();

        assertThat(names).containsExactly("pobi", "woni", "jun");
        Console.close();
    }

    void setInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
