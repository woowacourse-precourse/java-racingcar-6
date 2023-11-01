package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceCarsInputTest {
    private final RaceCarsInput inputManager = new RaceCarsInput();

    @Test
    void longNameTest() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("abcdef".getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(inputManager::getNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 입력값 오류");

        Console.close();
    }

    @Test
    void timesTest() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(inputManager::getTimes)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0회 이상 필요");

        Console.close();
    }
}
