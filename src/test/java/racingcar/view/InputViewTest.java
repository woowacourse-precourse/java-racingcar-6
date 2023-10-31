package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    void getInputName_함수_체크() {
        String args = "KO, Ko,kO, K0 , k0\n 1\n";
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        InputView inputView = new InputView();
        Object validTest = inputView.getInputNameList();

        assertThat(validTest).isEqualTo(Arrays.asList("KO", "Ko", "kO", "K0", "k0"));
    }

    @Test
    void getGameTurns_함수_체크() {
        String args = "1\n";
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        InputView inputView = new InputView();
        inputView.getInputTurns();

        assertThat(inputView.checkTurnOver()).isTrue();
        assertThat(inputView.checkTurnOver()).isFalse();
    }
}
