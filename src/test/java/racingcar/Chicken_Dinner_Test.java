package study;

import org.junit.jupiter.api.Test;
import racingcar.util.Car;
import racingcar.util.Chicken_Dinner;
import racingcar.util.Go_Stop_Selector;
import racingcar.util.Play;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Chicken_Dinner_Test {
    @Test
    void Find_Winner_테스트(){
        Go_Stop_Selector go_stop_Selector;
        Car car1 = new Car("pobi",5);
        Car car2 = new Car("min",3);
        Car car3 = new Car("woni",5);
        Car car4 = new Car("jin",4);
        List<Car> car = new ArrayList<Car>();
        List<Car> winner = new ArrayList<Car>();
        car.add(car1);
        car.add(car2);
        car.add(car3);
        car.add(car4);
        winner.add(car1);
        winner.add(car3);
        Chicken_Dinner play = new Chicken_Dinner(car,5);
        List<Car> result = play.Find_Winner();
        assertEquals(result,winner);
    }
}
