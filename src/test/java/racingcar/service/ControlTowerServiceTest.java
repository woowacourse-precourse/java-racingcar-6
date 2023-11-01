package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.ControlTower;
import racingcar.domain.GameRecord;

class ControlTowerServiceTest {

    ControlTowerService controlTowerService;

    @BeforeEach
    void init() {
        controlTowerService = new ControlTowerService(new ControlTower(), new GameRecord());
    }

    @Test
    @DisplayName("우승자 찾기")
    void judgmentWinner() {

        // Given
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("pobi",4));
        carList.add(new Car("woni", 4));
        carList.add(new Car("jun", 2));

        // When
        List<String> winnerList = controlTowerService.judgmentWinner(carList);

        // Then
        assertThat(winnerList).contains("pobi", "woni");
    }
}