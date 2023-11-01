package racingcar.global.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void 사용자_입력() {
        //given
        String expectedInput = "User Input";
        System.setIn(new ByteArrayInputStream(expectedInput.getBytes()));

        //when
        String actualInput = InputView.getUserInput();

        //then
        assertThat(actualInput).isEqualTo(expectedInput);
    }

}