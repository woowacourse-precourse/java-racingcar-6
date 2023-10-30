package racingcar;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class RacingGameTest {
    @Test
    public void 게임진행_최종_테스트() {
        RacingGame racingGame = new RacingGame();
        // 자동차 생성 및 게임 초기화
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        racingGame.prepareGame(new ArrayList<>(Arrays.asList(car1, car2)));
        // 게임 시작
        racingGame.startGame(5);
        // 결과 출력
        racingGame.printRoundResults();
        // 최종 우승자 확인
        String winner = racingGame.printGameWinner();
        assertNotNull(winner);
    }
}

