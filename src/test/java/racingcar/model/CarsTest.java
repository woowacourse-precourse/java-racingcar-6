package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars = new Cars();
    private Car pobi = new Car("pobi", 3);
    private Car woni = new Car("woni", 1);
    private Car jun = new Car("jun", 3);

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
        List<Car> carList = List.of(pobi, woni, jun);
        List<Car> winner = List.of(pobi, jun);

        cars.setCarList(carList);

        //When & Then
        assertEquals(winner, cars.getWinner());
    }

    @Test
    void 우승자들을_문자열로_조회() {
        //Given
        List<Car> winner = List.of(pobi, jun);

        //When
        String winnerMessage = cars.winnerToString(winner);

        //Then
        assertEquals("최종 우승자 : pobi, jun", winnerMessage);
    }

    @Test
    void 현재_자동차들의_이동상태_문자열로_조회() {
        //Given
        List<Car> carList = List.of(pobi, woni, jun);
        cars.setCarList(carList);

        //When
        String progressStatus = cars.getProgressStatus();

        //Then
        assertEquals("pobi : ---\n"
                + "woni : -\n"
                + "jun : ---\n\n", progressStatus);
    }
}
