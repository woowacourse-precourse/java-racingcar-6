package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class NarratorTest {
    @Test
    void 각_라운드_상황_보여주기() {
        Narrator narrator = new Narrator();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("이규빈"));
        cars.add(new Car("삼규빈"));
        cars.add(new Car("사규빈"));

        narrator.showEachRound(cars);
    }
}