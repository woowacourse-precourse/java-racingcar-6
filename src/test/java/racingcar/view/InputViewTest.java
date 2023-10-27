package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        inputStream = System.in;
    }

    @Test
    void 사용자_입력() {
        //given
        String expectedInput = "User Input";
        System.setIn(new ByteArrayInputStream(expectedInput.getBytes()));

        //when
        String actualInput = InputView.getUserInput();

        //then
        Assertions.assertThat(actualInput).isEqualTo(expectedInput);
    }

}