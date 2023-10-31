package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    Input input = new Input();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("중복된 이름을 입력시 예외 발생")
    void getCarNamesDuplicateTest() {
        //given
        System.setIn(makeUserInput("aa,bb,cc,aa"));

        //when

        //then
        assertThatThrownBy(() -> input.getCarNames()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 카운트 입력값이 1 미만이면 예외 발생")
    void getGameCountValidTest() {
        //given
        System.setIn(makeUserInput("0"));

        //when

        //then
        assertThatThrownBy(() -> input.getGameCount()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유저 입력값을 게임 카운트로 반환")
    void getGameCountTest() {
        //given
        System.setIn(makeUserInput("5"));

        //when
        GameCount gameCount = input.getGameCount();

        //then
        assertThat(gameCount).extracting("gameCount").isEqualTo(5);
    }

    @DisplayName("테스트코드용 유저입력 메소드")
    InputStream makeUserInput(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }
}
