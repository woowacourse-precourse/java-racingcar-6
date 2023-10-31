package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 자동차이름_입력테스트() {
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(InputView.getCarNames()).isEqualTo(input);
    }

    @Test
    void 시도횟수_입력테스트() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(InputView.getCarNames()).isEqualTo(input);
    }
}
