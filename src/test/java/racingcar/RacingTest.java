package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static  org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class RacingTest {

    @Test
    public void 한칸_전진() {
        Car car = new Car( "car",0);
        car.drive();
        assertThat(car.distance).isLessThan(2);
    }


    @Test
    public void 우승자_판정() {
        Race race = new Race();
        List<Car> list = new ArrayList<>();
        list.add(new Car("abc",3));
        list.add(new Car("b",2));
        list.add(new Car("c",1));
        race.allCars = list;
        race.selectWinner();
        assertThat(race.sb.toString()).isEqualTo("abc");
    }
}

