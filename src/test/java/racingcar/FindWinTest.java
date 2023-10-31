package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.controller.FindWin.findWinCars;

public class FindWinTest {
    @Test
    void 우승자가_없을_때() {
        Car car1 = new Car("a", 0);
        Car car2 = new Car("b", 0);
        Car car3 = new Car("c", 0);
        List<Car> testList = new ArrayList<>();

        testList.add(car1);
        testList.add(car2);
        testList.add(car3);
        List<String> winCars = findWinCars(testList);

        assertThat(0).isEqualTo(winCars.size());
    }

    @Test
    void 우승자가_한_명() {
        Car car1 = new Car("a", 1);
        Car car2 = new Car("b", 0);
        Car car3 = new Car("c", 0);
        List<Car> testList = new ArrayList<>();

        testList.add(car1);
        testList.add(car2);
        testList.add(car3);
        List<String> winCars = findWinCars(testList);

        assertThat(1).isEqualTo(winCars.size());
        assertThat("a").isEqualTo(winCars.get(0));
    }

    @Test
    void 우승자가_여러_명() {
        Car car1 = new Car("a", 1);
        Car car2 = new Car("b", 1);
        Car car3 = new Car("c", 0);
        List<Car> testList = new ArrayList<>();

        testList.add(car1);
        testList.add(car2);
        testList.add(car3);
        List<String> winCars = findWinCars(testList);

        assertThat(2).isEqualTo(winCars.size());
        assertThat("a").isEqualTo(winCars.get(0));
        assertThat("b").isEqualTo(winCars.get(1));
    }
}
