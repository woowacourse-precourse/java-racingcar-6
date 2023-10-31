package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameViewTest {
    private InputStream inputStream = System.in;

    @BeforeEach
    void init() {
        Console.close();
    }

    GameView gameView = new GameView();
    @DisplayName("자동차 이름 입력 검증 테스트")
    @Test
    void 자동차_입력_검증() {
        System.setIn(new ByteArrayInputStream("ab, cd , ef".getBytes()));
        List<String> carNames = gameView.getCarNames();
        assertThat(carNames).contains("ab", "cd", "ef");
    }

    @DisplayName("시도할 횟수 검증 테스트1")
    @Test
    void 시도횟수_입력_검증1() {
        System.setIn(new ByteArrayInputStream("0".getBytes()));
        assertThatThrownBy(() -> gameView.getTotalRounds())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 횟수 검증 테스트2")
    @Test
    void 시도횟수_입력_검증2() {
        System.setIn(new ByteArrayInputStream("ab".getBytes()));
        assertThatThrownBy(() -> gameView.getTotalRounds())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
