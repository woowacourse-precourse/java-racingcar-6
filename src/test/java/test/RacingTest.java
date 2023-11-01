package test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class RacingTest {

    @Test
    void 경주_자동차이름_반점_기준으로_구분() {
        String input = "pobi,woni,jun";
        String[] nameList = generateRacersFromNames(input);

        Assertions.assertThat(nameList).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

    @Test
    public void 포지션이_가장_앞선_자동차가_우승() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.goToPosition(); // Car1 1칸 전진
        car2.goToPosition(); // Car2 1칸 전진

        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList);
        List<String> winners = cars.findWinners();

        Assertions.assertThat(winners).containsExactly("Car1", "Car2");
    }

    @Test
    public void 포지션이_같은_자동차_구분() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.goToPosition(); // Car1 1칸 전진
        car2.goToPosition(); // Car2 1칸 전진

        Assertions.assertThat(car1.isSamePosition(car2)).isTrue(); // 포지션 같음
        Assertions.assertThat(car1.isSamePosition(car3)).isFalse(); // 포지션 다름
    }

    private String[] generateRacersFromNames(String input) {
        return input.split(",");
    }

}
