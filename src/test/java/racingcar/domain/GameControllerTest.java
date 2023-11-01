package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    private GameController gameController;
    private final String NAME_INPUT = "pobi,woni,jun";
    private final List<String> CAR_NAME_LIST = Arrays.asList("pobi", "woni", "jun");

    @BeforeEach
    void setUp() {
        gameController = new GameController();
    }

    @Test
    void 자동차_리스트_생성_테스트() {
        List<Car> carListResult = gameController.updateName(NAME_INPUT);
        for (Car car : carListResult) {
            assertThat(CAR_NAME_LIST).contains(car.getName());
        }
    }
}