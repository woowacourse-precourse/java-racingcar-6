package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {
    @Test
    void createCars() {
        String input = "pobi,woni,jun";
        List<Car> cars = Controller.inputToCarList(input);

        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
        assertThat(cars.get(2).getName()).isEqualTo("jun");
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
    }

    @Test
    void findWinner() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        for(int i = 0; i < 3; i++){
            Controller.isForward(cars);
        }
        List<Car> winnerCars = Controller.findWinner(cars);

        assertThat(winnerCars.size()).isLessThanOrEqualTo(2);
        assertThat(winnerCars.size()).isGreaterThan(0);
    }
}
