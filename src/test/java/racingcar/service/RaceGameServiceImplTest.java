package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;

class RaceGameServiceImplTest {

    RaceGameService raceGameService = new RaceGameServiceImpl();

    @Test
    @DisplayName("모든 자동차는 시작위치(0) 에서 시작해야한다")
    void startGameTest() {
        // given
        ArrayList<String> input = new ArrayList<>();
        input.add("pobi");
        input.add("woni");
        // when
        Car car = raceGameService.startGame(input);
        // then
        Assertions.assertThat(car.getCarPosition().get(0)).isEqualTo(0);
        Assertions.assertThat(car.getCarPosition().get(1)).isEqualTo(0);
    }
}