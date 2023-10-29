package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.RandomNumberGenerator;
import racingcar.domain.Game;
import racingcar.domain.dto.CarDtos;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        RandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(3);
        game = new Game("car1,car2,car3", "5",testRandomNumberGenerator);
    }

    @Test
    void 게임한_라운드후_모든자동차_전진_테스트() {
        RandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(4);
        Game testGame = new Game("car1,car2,car3", "1", testRandomNumberGenerator);
        testGame.playRound();
        CarDtos carDtos = testGame.createCarDtos();
        assertEquals(1, carDtos.getCarDtos().get(0).getPosition());
        assertEquals(1, carDtos.getCarDtos().get(1).getPosition());
        assertEquals(1, carDtos.getCarDtos().get(2).getPosition());
    }

    @Test
    void 게임한_라운드후_모든자동차_멈춤_테스트() {
        game.playRound();
        CarDtos carDtos = game.createCarDtos();
        assertEquals(0, carDtos.getCarDtos().get(0).getPosition());
        assertEquals(0, carDtos.getCarDtos().get(1).getPosition());
        assertEquals(0, carDtos.getCarDtos().get(2).getPosition());
    }

    @Test
    void 게임_진행_테스트() {
        for (int i = 0; i < 5; i++) {
            game.playRound();
        }
        assertTrue(game.isFinished());
    }

    @Test
    void 게임_미진행_테스트() {
        for (int i = 0; i < 4; i++) {
            game.playRound();
        }
        assertFalse(game.isFinished());
    }
}
