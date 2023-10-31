package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void nameInputTest() {
        //given
        InputView inputView = new InputView();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("pobi,java".getBytes());
        System.setIn(byteArrayInputStream);

        //when
        final List<String> list = inputView.inputCarName();

        //then
        assertThat(list).contains("pobi", "java");
    }

    @Test
    @DisplayName("시도 횟수 입력 테스트")
    void trialCountInputTest() {
        //given
        InputView inputView = new InputView();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("10".getBytes());
        System.setIn(byteArrayInputStream);

        //when
        final int trialCount = inputView.inputTrialCount();

        //then
        assertThat(trialCount).isEqualTo(10);
    }
}
