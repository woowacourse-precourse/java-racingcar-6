package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    @Test
    void 자동차_객체_생성_기능(){
        String[] carName = {"jin", "ive", "cute"};
        game.generateCar(carName);

        assertThat(game).isNotNull();
    }

    @Test
    void 주어진_범위에서_랜덤숫자_반환_기능(){
        int result = game.getRandomNumber();

        assertThat(result).isBetween(0, 9);
    }

    @Test
    void 전진인_경우_1_반환(){
        int result = game.moveForwardStep(Randoms.pickNumberInRange(4,9));

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 정지인_경우_0_반환(){
        int result = game.moveForwardStep(Randoms.pickNumberInRange(0,3));

        assertThat(result).isEqualTo(0);
    }
}
