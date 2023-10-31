package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class GameViewTest extends NsTest {
    GameView gameView = new GameView();
    @DisplayName("자동차 이름 입력 검증 테스트")
    @Test
    void 자동차_입력_검증() {
        System.setIn(new ByteArrayInputStream("ab, cd , ef".getBytes()));
        List<String> carNames = gameView.getCarNames();
        assertThat(carNames).contains("ab", " cd ", " ef");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
