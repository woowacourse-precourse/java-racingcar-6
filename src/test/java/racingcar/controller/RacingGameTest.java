package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void 단독_우승자_계산(){
        RacingGame racingGame = new RacingGame();
        List<Car> carList = new ArrayList<>();
        racingGame.carList = carList;
        carList.add(new Car("자동차1", "-"));
        carList.add(new Car("자동차2", "---"));
        carList.add(new Car("자동차3", "--"));


        List<String> result = racingGame.calcWinner();
        assertThat(result.get(0)).isEqualTo("자동차2");
    }

    @Test
    void 공동_우승자_계산(){
        RacingGame racingGame = new RacingGame();
        List<Car> carList = new ArrayList<>();
        racingGame.carList = carList;
        carList.add(new Car("자동차1", "-"));
        carList.add(new Car("자동차2", "---"));
        carList.add(new Car("자동차3", "---"));


        List<String> result = racingGame.calcWinner();
        assertThat(result.get(0)).isEqualTo("자동차2");
        assertThat(result.get(1)).isEqualTo("자동차3");
    }
}