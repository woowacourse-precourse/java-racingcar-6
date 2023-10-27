package racingcar;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;

class RacingGameTest {
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

    @Test
    @DisplayName("0에서 9까지의 무작위 숫자를 생성한다.")
    void test3() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        assertThat(randomNumber).isBetween(0, 9);
    }
}
