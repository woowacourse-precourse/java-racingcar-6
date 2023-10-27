package racingcar;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;

public class RacingGameTest {
    @Test
    @DisplayName("자동차에 이름을 부여한다.")
    void test1() {
        System.setIn(new ByteArrayInputStream("pobi,go,kim".getBytes()));
        String carNames = Console.readLine();
        RacingGame racingGame = new RacingGame(carNames);

        assertThat(racingGame.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어에게 시도 횟수를 묻는다.")
    void test2() {
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        int playCount = Integer.parseInt(Console.readLine());

        assertThat(playCount).isEqualTo(5);
    }
}
