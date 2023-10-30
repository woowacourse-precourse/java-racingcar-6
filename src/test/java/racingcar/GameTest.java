package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    @Test
    @DisplayName("자동차들의 현재위치를 리스트로 잘 뽑아내는지 테스트")
    public void makeLocationListTest() {
        List<Car> cars = getTestCars();

        Game game = new Game();
        List<Integer> location = game.makeLocationList(cars);

        Assertions.assertEquals(4, location.size());
        Assertions.assertEquals(1, location.get(1));
    }

    @Test
    @DisplayName("중복 포함, 가장 멀리 이동한 차량을 리스트로 잘 반환하는가?")
    public void findWinnerTest() {
        List<Car> cars = getTestCars();

        Game game = new Game();
        List<Car> winnerCars = game.findWinner(cars);

        Assertions.assertEquals(2, winnerCars.size());
        Assertions.assertEquals("car3", winnerCars.get(0).getName());
        Assertions.assertEquals(4, winnerCars.get(0).getCurrentLocation());
    }

    private List<Car> getTestCars() {
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car(3, "car1");
        cars.add(car1);
        Car car2 = new Car(1, "car2");
        cars.add(car2);
        Car car3 = new Car(4, "car3");
        cars.add(car3);
        Car car4 = new Car(4, "car4");
        cars.add(car4);
        return cars;
    }
}
