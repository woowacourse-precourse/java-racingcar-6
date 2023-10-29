package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.ConsoleInterceptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameShellTest {
    GameShell gameShell = new GameShell();

    @BeforeEach
    void setupConsoleInterceptor() {
        ConsoleInterceptor.setupConsoleIntercept();
    }

    @AfterEach
    void restoreConsoleInterceptor() {
        ConsoleInterceptor.restoreConsoleIntercept();
        Console.close(); // Console 작동방식떄문에 매번 닫아주는 것이 필요함.
    }

    @DisplayName("라운드횟수를 제대로 묻고 입력받는다")
    @Test
    void askRoundCountTest1() {
        // given
        System.setIn(ConsoleInterceptor.getInputStream("1"));

        // when
        int roundCount = gameShell.askRoundCount();
        String question = ConsoleInterceptor.getPrintedString();

        // then
        assertThat(roundCount).isEqualTo(1);
        assertThat(question).contains("시도할 회수는 몇회인가요?");
    }

    @DisplayName("라운드횟수는 숫자만 입력받는다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "a1", "1a1", "a1a", "1.1"})
    void askRoundCountTest2(String input) {
        // given
        System.setIn(ConsoleInterceptor.getInputStream(input));

        // then
        assertThatThrownBy(() -> gameShell.askRoundCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자형식");
    }

    @DisplayName("라운드횟수의 범위는 int 범위를 넘을 수 없다")
    @Test
    void askRoundCountTest3() {
        // given
        System.setIn(ConsoleInterceptor.getInputStream("21345678900"));

        // then
        assertThatThrownBy(() -> gameShell.askRoundCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }
}
