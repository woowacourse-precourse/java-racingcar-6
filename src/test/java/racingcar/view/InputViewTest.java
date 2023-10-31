package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 자동차_이름들_입력() {
        System.setIn(createUserInput("pobi,woni"));

        Assertions.assertThat(InputView.readCarNames()).isEqualTo("pobi,woni");
    }

    @Test
    void 이동_횟수_입력() {
        System.setIn(createUserInput("3"));

        Assertions.assertThat(InputView.readNumber()).isEqualTo("3");
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}