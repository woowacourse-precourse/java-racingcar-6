package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinnerTest {

    //여러명의 winner가 나오는가
    @Test
    void 여러명의_winner(){
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("aaa"));
        cars.add(new Car("bbb"));
        cars.add(new Car("cccc"));
        Winner winner = new Winner(cars);

        //when
        List<String> winnerCars = winner.whoIsWinner();

        //then
        Assertions.assertEquals(cars.size(), winnerCars.size());

    }

}
