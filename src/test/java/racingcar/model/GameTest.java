package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @Test
    public void makeRandomNumberTest() {
        Game game = new Game();
        int randomNumber = game.makeRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    public void StringListChangeCarList() {
        List<String> carNames = new ArrayList<>(){{
           add("test");
        }};

        List<Car> cars = new ArrayList<>();

        for(String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        assertThat(cars.get(0)).isInstanceOf(Car.class);
    }
}
