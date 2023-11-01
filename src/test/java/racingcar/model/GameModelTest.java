package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.GameModel;
import model.RacingCarInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameModelTest {
    private GameModel gameModel;

    @BeforeEach
    public void setup() {
        String[] carNames = {"Car1", "Car2", "Car3"};
        gameModel = new GameModel(carNames);
    }

    @Test
    public void testUpdateRaceStatus() {
        gameModel.updateRaceStatus();
        for (RacingCarInfo carInfo : gameModel.racingCarInfos) {
            assertThat(carInfo.moveCount).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    public void testGetWinnerNames() {
        gameModel.racingCarInfos.get(0).moveCount = 5;
        gameModel.racingCarInfos.get(1).moveCount = 3;
        gameModel.racingCarInfos.get(2).moveCount = 5;

        List<String> winners = gameModel.getWinnerNames();
        assertThat(winners).containsExactly("Car1", "Car3");
    }

}
