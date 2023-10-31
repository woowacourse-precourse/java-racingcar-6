package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utill.NumberGenerator;


class CarsTest {

    private final NumberGenerator numberGenerator = () -> 8;

    @Test
    void findWinnerTest() {
        //given
        List<Car> testCarList = new ArrayList<>();
        testCarList.add(new Car("haha"));
        testCarList.add(new Car("hoho"));
        Cars cars = new Cars(testCarList, numberGenerator);

        //when
        String winner = cars.findWinner();

        //then
        assertEquals(winner, "haha, hoho");
    }
}