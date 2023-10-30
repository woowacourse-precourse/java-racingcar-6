package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.util.Constants;
import racingcar.util.Convertor;
import racingcar.view.InputView;

public class ApplicationSelfTest {

//    @BeforeAll

    @Test
    void 자동차_이름_입력() {
        String carNames = "권쵸파,권루피,권조로";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        InputStream in = new ByteArrayInputStream(carNames.getBytes());
        System.setIn(in);

        String carName = InputView.inputString(Constants.INPUT_CAR_NAME);

        assertThat(carName).isInstanceOf(String.class);
    }

    @Test
    void 자동차이름_입력_받고_값을_구분() {

        String carName = "권쵸파,권루피,권조로";

        List<String> result = Convertor.splitCarNamesByComma(carName);

        assertThat(result).containsExactly("권쵸파", "권루피", "권조로");
    }

    @Test
    void validator_입력_값_Test() {

        String carName = "권쵸파,권루피,권조로";

        List<String> result = Convertor.splitCarNamesByComma(carName);

        assertThat(result).containsExactly("권쵸파", "권루피", "권조로");
    }

//    @Test
//    void
}
