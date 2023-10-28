package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    InputView inputView = new InputView();

    @Test
    void 자동차_이름에_대한_입력을_쉼표_구분() {
        // given
        String userInput = "Morning,Tico";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // when
        List<String> carNameList = inputView.inputCarNames();
        // then
        assertThat(carNameList).contains("Morning", "Tico");
    }
}
