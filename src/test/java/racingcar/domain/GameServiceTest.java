package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @Test
    public void 레이싱을_한다() {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car(new TestNumberGenerator(5)));
        carList.add(new Car(new TestNumberGenerator(3)));
        carList.add(new Car(new TestNumberGenerator(6)));
        GameService gameService = new GameService(carList);

        gameService.doRacing();

        List<Car> status = gameService.getStatus();
        assertThat(status).filteredOn(car->car.getLocation()!=0).hasSize(2);
    }

}
