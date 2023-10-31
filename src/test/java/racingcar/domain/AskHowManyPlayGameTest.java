package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class AskHowManyPlayGameTest {
    @Test
    void askHowManyPlayGame_정상값_테스트() {
        int randomNumber = Randoms.pickNumberInRange(0, 10);
        String input = Integer.toString(randomNumber);
        AskHowManyPlayGame askHowManyPlayGame = new AskHowManyPlayGame();

        if (!input.equals("0")) {   // 사용자 입력값이 "0"이 아니면서 숫자일 때,
            assertThat(askHowManyPlayGame.askHowManyPlayGame(input)).isEqualTo(Integer.parseInt(input));
        } else {    // 사용자 입력값이 "0"일 때,
            assertThatThrownBy(() -> askHowManyPlayGame.askHowManyPlayGame(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void askHowManyPlayGame_에러_테스트() {
        String input = "열번";    // 사용자 입력값이 숫자가 아닐 때
        AskHowManyPlayGame askHowManyPlayGame = new AskHowManyPlayGame();

        assertThatThrownBy(() -> askHowManyPlayGame.askHowManyPlayGame(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
