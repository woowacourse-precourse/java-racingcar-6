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
    void getCarsWrongName_Test() {
        // given
        System.setIn(createUserInput("kim,lee,park,"));
        // when, then
        Assertions.assertThatThrownBy(() -> inputView.getCarsName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 입력이에요.");
    }

    @Test
    void getCarsEmptyName_Test() {
        // given
        System.setIn(createUserInput("\n"));
        // when, then
        Assertions.assertThatThrownBy(() -> inputView.getCarsName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 입력이에요.");
    }

    @Test
    void getTryNumber_Test() {
        // given
        System.setIn(createUserInput("3"));
        // when, then
        Assertions.assertThat(inputView.getTryNumber()).isEqualTo("3");
    }

    @Test
    void getTryWrongNumber_Test() {
        // given
        System.setIn(createUserInput(" "));
        // when, then
        Assertions.assertThatThrownBy(() -> inputView.getTryNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }
}
