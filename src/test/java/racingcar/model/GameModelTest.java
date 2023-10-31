package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameModelTest {
    private GameModel gameModel;

    @BeforeEach
    void setUp() {
        String[] carNames = {"carA", "carB", "carC"};
        int tryCount = 5;
        gameModel = new GameModel(carNames, tryCount);
    }

    @Test
    void 자동차_이동_테스트() {
        Car car = gameModel.getCars().get(0);
        int initialPosition = car.getPosition();

        gameModel.moveCars();

        assertEquals(initialPosition + 1, car.getPosition());
    }
}
