package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class UserInputTest extends NsTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("잘못된 횟수 데이터가 입력되었을 때 예외발생 테스트")
    void readRound() {
        assertThatThrownBy(() -> runException("hello", "ds3"))
                .isInstanceOf(IllegalArgumentException.class);
        //when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(UserInput.readCarName()))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("잘못된 자동차이름 데이터가 입력되었을 때 예외발생 테스트")
    void shouldThrowExceptionForInvalidCarName() {
        //given
        System.setIn(createUserInput("bella,TooLongCarName"));
        //when, then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(UserInput.readCarName()))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이동 횟수를 입력 받고, 이 횟수가 올바르게 저장되는지 확인하는 테스트")
    void shouldAcceptNumberOfMoves() {
        //given
        System.setIn(createUserInput("5"));
        //when
        int moves = UserInput.readRound();
        //then
        assertEquals(5, moves);
    }

    @Test
    @DisplayName("올바른 자동차 이름을 입력하고, 이 이름이 올바르게 저장되는지 확인")
    void shouldAcceptCarName() {
        //given
        System.setIn(createUserInput("pobi,judy,bella"));
        //when
        String[] carNames = UserInput.readCarName();
        //then
        assertArrayEquals(new String[]{"pobi", "judy", "bella"}, carNames);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}