package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinnerTest {

    @Test
    void 가장_멀리_간_자동차의_위치_반환_테스트() {
        String[] nameList = {"pobi", "woni", "jun"};
        int[] randomNum = {5, 5, 0};

        List<Car> carList = new ArrayList<>();
        for (int idx = 0; idx < nameList.length; idx++) {
            Car car = new Car(nameList[idx]);
            car.move(randomNum[idx]);
            carList.add(car);
        }

        Assertions.assertThat(Winner.findFarthestCarPosition(carList))
                .isEqualTo(1);

    }

    @Test
    void 우승자_반환_테스트() {
        String[] nameList = {"pobi", "woni", "jun"};
        int[] randomNum = {5, 5, 0};

        List<Car> carList = new ArrayList<>();
        for (int idx = 0; idx < nameList.length; idx++) {
            Car car = new Car(nameList[idx]);
            car.move(randomNum[idx]);
            carList.add(car);
        }

        int farthestCarPosition = Winner.findFarthestCarPosition(carList);
        Assertions.assertThat(Winner.winnerList(carList, farthestCarPosition))
                .isEqualTo(Arrays.asList("pobi", "woni"));

    }
}
