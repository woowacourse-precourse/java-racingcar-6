package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars = new Cars();

    @DisplayName("자동차 이름을 콤마로 구분하여 저장")
    @Test
    void saveCarNameByComma() {
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

    @DisplayName("가장 긴 이동거리를 가진 차들이 우승자")
    @Test
    void winnerIsHaveLongestDistance() {
        //Given
        Car pobi = new Car("pobi", 3);
        Car woni = new Car("woni", 1);
        Car jun = new Car("jun", 3);

        List<Car> carList = List.of(pobi, woni, jun);
        List<Car> winner = List.of(pobi, jun);

        cars.setCarList(carList);

        //When & Then
        assertEquals(winner, cars.getWinner());
    }
}
