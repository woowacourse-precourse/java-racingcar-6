package racingcar.UtilTest;


import org.junit.jupiter.api.Test;
import racingcar.Util.Winner;
import racingcar.domain.CarList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @Test
    void 단일_우승자() {

        String name1 = "베이스볼";
        String name2 = "레이싱카";

        List<CarList> cars = new ArrayList<>();
        cars.add(new CarList(name1));

        CarList car1 = new CarList(name2);
        car1.moving(6);
        cars.add(car1);

        List<String> result = Winner.carList(cars);
        List<String> expectedWinner = Arrays.asList("레이싱카");
        assertThat(result).isEqualTo(expectedWinner);

    }

    @Test
    void 공동_우승자() {

        String name1 = "베이스볼";
        String name2 = "레이싱카";

        List<CarList> cars = new ArrayList<>();
        cars.add(new CarList(name1));

        CarList car1 = new CarList(name2);
        cars.add(car1);

        List<String> result = Winner.carList(cars);
        List<String> expectedWinner = Arrays.asList("베이스볼", "레이싱카");
        assertThat(result).isEqualTo(expectedWinner);

    }

    @Test
    void 우승한_자동차_위치() {
        String name1 = "베이스볼";

        List<CarList> cars = new ArrayList<>();
        CarList car = new CarList(name1);
        car.moving(6);
        car.moving(6);
        car.moving(3);
        cars.add(car);

        Winner.carList(cars);

        assertThat(Winner.getRacingMaxLocation()).isEqualTo(2);

    }
}
