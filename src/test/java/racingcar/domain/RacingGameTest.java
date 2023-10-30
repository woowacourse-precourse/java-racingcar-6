package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    public void 레이싱을_한다() {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car(new TestNumberGenerator(5)));
        carList.add(new Car(new TestNumberGenerator(3)));
        carList.add(new Car(new TestNumberGenerator(6)));
        RacingGame gameService = new RacingGame(carList);

        gameService.doRacing();

        assertThat(gameService.getStatus()).filteredOn(car -> car.getLocation() != 0).hasSize(2);
    }

}
