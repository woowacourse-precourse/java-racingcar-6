package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameManagementTest {
    @Test
    void 최종우승_확인() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        GameManagement game = new GameManagement(carNames);
        List<CarInformation> cars = game.getCars();
        cars.get(0).position++;

        List<CarInformation> winners = game.getWinners();
        String winnerName = winners.get(0).getName();

        assertThat(winnerName).isEqualTo("Car1");
    }

    @Test
    void 공동우승_확인() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        GameManagement game = new GameManagement(carNames);
        List<CarInformation> cars = game.getCars();
        cars.get(0).position++;
        cars.get(2).position++;

        List<CarInformation> winners = game.getWinners();
        List<String> winnerNames = new ArrayList<>();

        for (CarInformation winner : winners) {
            winnerNames.add(winner.getName());
        }

        assertThat(winnerNames).isEqualTo(Arrays.asList("Car1", "Car3"));
    }
}