package fuction;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingcar.InputManager;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputManagerTest {
    private final InputManager inputManager = new InputManager();

    @Test
    void longNameTest() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("abcdef".getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(inputManager::getNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[입력오류] 1글자 이상, 5글자 이하의 이름만 가능합니다.");

        Console.close();
    }

    @Test
    void sameNameTest() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("p1,p1,p2".getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(inputManager::getNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[입력오류] 동일한 이름이 입력되었습니다.");

        Console.close();
    }

    @Test
    void timesTest() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("notNumber".getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(inputManager::getTimes)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[입력오류] 자연수를 입력해야 합니다.");

        Console.close();
    }

    @Test
    void timesTest2() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("-3".getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(inputManager::getTimes)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[입력오류] 자연수를 입력해야 합니다.");

        Console.close();
    }
}
