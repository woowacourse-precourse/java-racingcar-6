package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    Input input = new Input();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("입력값이 1 미만이면 예외 발생")
    void getGameCountTest() {

        //given
        System.setIn(makeUserInput("0"));

        //when

        //then
        assertThatThrownBy(() -> input.getGameCount()).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("테스트코드용 유저입력 메소드")
    InputStream makeUserInput(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }
}
