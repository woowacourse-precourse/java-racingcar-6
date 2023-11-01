package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private static final String INPUT_NAME = "pobi,woni,jun";
    private List<Car> carList = new ArrayList<>();
    private GameResult gameResult;
    private GameController gameController;

    @BeforeEach
    public void setUp() {
        gameController = new GameController();
        gameResult = new GameResult();
        carList = gameController.updateName(INPUT_NAME);
    }

    @Test
    void 단독우승자() {
        String winner = "";
        List<String> locationResult = Arrays.asList("----", "--", "---");
        for (int carNumber = 0; carNumber < carList.size(); carNumber++) {
            carList.get(carNumber).setLocation(locationResult.get(carNumber));
        }
        winner = gameResult.findWinner(carList);
        assertThat(winner).isEqualTo("최종 우승자 : pobi");
    }

    @Test
    void 공동우승자() {
        String winner = "";
        List<String> locationResult = Arrays.asList("-----", "-----", "-----");
        for (int carNumber = 0; carNumber < carList.size(); carNumber++) {
            carList.get(carNumber).setLocation(locationResult.get(carNumber));
        }
        winner = gameResult.findWinner(carList);
        assertThat(winner).isEqualTo("최종 우승자 : pobi, woni, jun");
    }
}