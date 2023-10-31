package racingcar;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class RacingGameTest {
    @Test
    public void 게임진행_최종_테스트() {
        RacingGame racingGame = new RacingGame();
        // 자동차 생성 및 게임 초기화
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2"));
        Cars cars = new Cars(carNames);
        racingGame.prepareGame(cars);
        // 게임 시작
        racingGame.startGame(5);
    }
}

