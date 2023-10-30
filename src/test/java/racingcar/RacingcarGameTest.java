package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingcarGameTest {

    RacingcarGame racingcarGame = new RacingcarGame();

    @Test
    void race_레이스_진행시_차이름과_거리가_반환() {
        racingcarGame.setTryCount(1);
        String[] cars = {"test"};
        racingcarGame.setCars(cars);
        assertThat(racingcarGame.race().get("test")).isBetween(0,1);
    }
}