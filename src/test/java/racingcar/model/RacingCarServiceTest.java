package racingcar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {
    RacingCarService racingCarService = new RacingCarService();
    GameCount gameCount = new GameCount();
    Cars cars = new Cars();
    List<String> list = new ArrayList<>();

    final int SET_GAME_COUNT = 10;

    @BeforeEach
    void before() {
        for (String key : "a,b,c".split(",")) list.add(key);
        cars.setCarsData(list);
        gameCount.setGameCount(SET_GAME_COUNT);
    }

    @AfterEach
    void after() {
        cars.getCarsData().clear();
        list.clear();
        gameCount.setGameCount(0);
    }

    @Test
    void executeResult() {
        Cars cars = racingCarService.executeResult();
        Collection<Integer> values = cars.getCarsData().values();
        boolean result = values.stream().anyMatch(value -> 0 <= value && value <= SET_GAME_COUNT);
        assertThat(result).isTrue();
    }

    @Test
    void setWinner() {
        racingCarService.executeResult();
        gameCount.setHighStep();
        List<String> winners = racingCarService.setWinner();
        int count = winners.size();
        boolean winnnerNum = 0 <= count && count <= SET_GAME_COUNT;
        assertThat(winnnerNum).isTrue();
    }
}