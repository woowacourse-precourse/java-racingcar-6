package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    final byte[] buf = "KO, Ko,kO, K0 , k0\n 10\n".getBytes();

    @Test
    void getInputName_함수_체크() {
        System.setIn(new ByteArrayInputStream(buf));

        InputView inputView = new InputView();
        Object validTest = inputView.getInputNameList();

        assertThat(validTest).isEqualTo(Arrays.asList("KO", "Ko", "kO", "K0", "k0"));
    }

    @Test
    void getGameTurns_함수_체크() {
        InputView inputView = new InputView();
        int validTest = inputView.getGameTurns();

        assertThat(validTest).isEqualTo(10);
    }
}
