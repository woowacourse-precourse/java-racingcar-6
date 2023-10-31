package racingcar.view;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(list).contains("pobi", "java");
    }
}
