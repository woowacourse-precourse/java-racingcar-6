package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.view.InputView.*;

class InputViewTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void joinCarsName() {
        systemIn("a,b,c");
        List<String> list = List.of("a", "b", "c");

        List<String> joinCarsName = inputJoinCarsName();

        assertThat(joinCarsName).isEqualTo(list);
    }

    @Test
    void gameCount() {
        systemIn("6,2,5");
        String result = inputGameCount();
        assertThat(result).isEqualTo("6,2,5");
    }

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}