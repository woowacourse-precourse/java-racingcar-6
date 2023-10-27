package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


class CarListTest {

    @Test
    void stringToCarListTest() {
        //given
        List<Car> testCarList = new ArrayList<>();
        testCarList.add(new Car("zizi"));
        testCarList.add(new Car("hoho"));
        testCarList.add(new Car("haha"));

        //when
        CarList carList = new CarList(testCarList);

        //then
        assertEquals(carList.toString(), testCarList.toString());
    }

    @Test
    void racingWinnerDecisionTest() {
        //given
        List<Car> testCarList = new ArrayList<>();
        Car winnerCar = new Car("zizi");
        winnerCar.stopOrMoveDecision(5);
        testCarList.add(winnerCar);
        testCarList.add(new Car("hoho"));
        testCarList.add(new Car("haha"));
        CarList carList = new CarList(testCarList);

        //when
        String winner = carList.racingWinnerDecision();

        //then
        assertEquals(winner, "zizi");
    }
}