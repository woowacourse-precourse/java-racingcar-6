package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputViewTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void receiveUserInputTest_사용자_입력을_받아서_리턴() {
        String input = "pobi,hoon";
        String result;
        InputStream in = generateUserInput(input);
        System.setIn(in);

        result = InputView.receiveUserInput();

        assertThat(result).isEqualTo("pobi,hoon");
    }
}
