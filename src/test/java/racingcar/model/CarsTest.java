package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    public void Cars_생성에_성공한다() {
        String[] carNames = {"car1", "car2", "car3"};
        Cars cars = new Cars(carNames);

        assertEquals(3, cars.getCars().size());
    }

    @Test
    public void Cars_move에_성공한다() {
        String[] carNames = {"car1", "car2", "car3"};
        Cars cars = new Cars(carNames);

        cars.moveCars();

        for (Car car : cars.getCars()) {
            assertTrue(car.getPosition() >= 0);
        }
    }

    @Test
    public void 우승자_출력에_성공한다() {
        String[] carNames = {"car1", "car2", "car3"};
        Cars cars = new Cars(carNames);

        cars.moveCars();

        int maxPosition = cars.getCars().stream()
                .max(Comparator.comparing(Car::getPosition))
                .get()
                .getPosition();

        List<Car> winners = cars.getWinnerCars();

        for (Car car : winners) {
            assertEquals(maxPosition, car.getPosition());
        }
    }
}
