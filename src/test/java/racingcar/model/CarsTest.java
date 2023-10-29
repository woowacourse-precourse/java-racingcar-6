package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars = new Cars();

    @Test
    void 자동차_이름이_콤마로_구분되어_저장된다() {
        //Given
        String inputString = "pobi, woni, jun";

        //When
        cars.setCarList(inputString);
        List<Car> carList = cars.getCarList();

        //Then
        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
        assertEquals("jun", carList.get(2).getName());
    }

    @Test
    void 가장_많은_거리를_이동한_차량들을_우승자로_뽑는다() {
        //Given
        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("woni", 1);
        Car car3 = new Car("jun", 3);

        List<Car> carList = List.of(car1, car2, car3);
        List<Car> winner = List.of(car1, car3);

        cars.setCarList(carList);

        //When & Then
        assertEquals(winner, cars.getWinner());
    }

    @Test
    void 현재_자동차들의_이동상태_문자열로_조회() {
        //Given
        List<Car> carList = List.of(
                new Car("pobi", 3),
                new Car("woni", 1),
                new Car("jun", 3)
        );
        cars.setCarList(carList);

        //When
        String progressStatus = cars.getProgressStatus();

        //Then
        assertEquals("pobi : ---\n"
                + "woni : -\n"
                + "jun : ---\n\n", progressStatus);

    }
}
