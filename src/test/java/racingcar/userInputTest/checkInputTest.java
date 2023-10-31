package racingcar.userInputTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.view.inputView;

public class checkInputTest {
    @Test
    void 쉼표가_들어있는지_확인() {
        System.setIn(createUserInput("1,2"));
        Assertions.assertThat(inputView.gameStart()).contains(",");
    }


    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
