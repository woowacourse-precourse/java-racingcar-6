package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {

    @Test
    @DisplayName("start메소드 사용시 gameCount가 0이 될때까지 반복")
    void startTest() {
        //given
        List<CarName> carNameList = Arrays.asList(new CarName("test1"), new CarName("test2"), new CarName("test3"));
        CarNames carNames = new CarNames(carNameList);
        Cars cars = new Cars(carNames);

        GameCount gameCount = new GameCount("3");
        CarRacingGame carRacingGame = new CarRacingGame(new Output());

        //when
        carRacingGame.start(gameCount, cars);

        //then
        assertThat(gameCount).extracting("gameCount").isEqualTo(0);
    }
}
