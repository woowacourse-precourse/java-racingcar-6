package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.car.UserInputCarName;
import racingcar.game.ProcessGame;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    void 자동차_생성_기능(){
        String carName = "a, b,e";
        assertThat(UserInputCarName.processInput(carName)).isNotNull();
    }
    @Test
    void 랜덤숫자_반환_기능(){
        int randomNumber = ProcessGame.randomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void 전진_여부_true_반환_기능(){
        boolean forward = ProcessGame.isForward(Randoms.pickNumberInRange(4,9));
        assertThat(forward).isEqualTo(true);
    }

    @Test
    void 전진_여부_false_반환_기능(){
        boolean forward = ProcessGame.isForward(Randoms.pickNumberInRange(0,3));
        assertThat(forward).isEqualTo(false);
    }
}
