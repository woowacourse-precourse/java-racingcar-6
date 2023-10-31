package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {


    @Test
    void 제일_멀리_가있는_자동차_찾기(){
        List<Car> carList = Arrays.asList(new Car("poni"), new Car("woni"), new Car("jun"));
        carList.get(0).move();
        carList.get(0).move();
        carList.get(0).move();

        carList.get(1).move();
        carList.get(1).move();

        carList.get(2).move();

        List<Car> winnerCarList = Comparator.compare(carList);

        assertEquals(winnerCarList.get(0).getName(), "poni");
    }
}