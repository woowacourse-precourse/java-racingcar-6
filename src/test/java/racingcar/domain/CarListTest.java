package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utill.NumberGenerator;


class CarListTest {

    private final NumberGenerator numberGenerator = () -> 8;

    @Test
    void racingWinnerDecisionTest() {
        //given
        List<Car> testCarList = new ArrayList<>();
        testCarList.add(new Car("haha"));
        testCarList.add(new Car("hoho"));
        CarList carList = new CarList(testCarList, numberGenerator);

        //when
        String winner = carList.decisionRacingWinner();

        //then
        assertEquals(winner, "haha, hoho");
    }
}