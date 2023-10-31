package study;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.View.InputView;

public class InputViewTest {
    InputView inputView = new InputView();

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void getCarsName_Test() {
        // given
        System.setIn(createUserInput("kim,lee,park"));
        // when, then
        Assertions.assertThat(inputView.getCarsName()).isEqualTo(List.of("kim", "lee", "park"));
    }

    @Test
    void getTryNumber_Test() {
        // given
        System.setIn(createUserInput("3"));
        // when, then
        Assertions.assertThat(inputView.getTryNumber()).isEqualTo("3");
    }

}
