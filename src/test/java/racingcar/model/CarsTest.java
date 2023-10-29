package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars = new Cars();

    @Test
    void 자동차_이름이_콤마로_구분되어_저장된다() {
        //Given
        String inputString = "포비, 워니, 차니";

        //When
        cars.setCarList(inputString);
        List<Car> carList = cars.getCarList();

        //Then
        assertEquals("포비", carList.get(0).getName());
        assertEquals("워니", carList.get(1).getName());
        assertEquals("차니", carList.get(2).getName());
    }

    @Test
    void 가장_많은_거리를_이동한_차량들을_우승자로_뽑는다() {
        //Given
        Car car1 = new Car("포비", 3);
        Car car2 = new Car("워니", 1);
        Car car3 = new Car("차니", 3);

        List<Car> carList = List.of(car1, car2, car3);
        List<Car> winner = List.of(car1, car3);

        cars.setCarList(carList);

        //When & Then
        assertEquals(winner, cars.getWinner());
    }
}
