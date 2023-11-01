package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class TryInputManageTest {
    TryInputManage tryInputManage = new TryInputManage();
    InputView inputView = new InputView();

    @Test
    void 시도_회수_문자에서_숫자_변환() {
        String attempt = "2";
        InputStream in = new ByteArrayInputStream(attempt.getBytes());
        System.setIn(in);
        
        assertThat(tryInputManage.makeTryNumber(inputView))
                .isEqualTo(Integer.parseInt(attempt));
    }
}
