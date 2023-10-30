package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarList;

class RacingGameTest {

    private RacingGame racingGame = new RacingGame();

    @Test
    void 쉼표를_기준으로_자동차의_이름을_입력받기(){
        CarList carList = racingGame.generateCar("povi,woni,minu");
        assertThat(carList.size()).isEqualTo(3);
    }

}