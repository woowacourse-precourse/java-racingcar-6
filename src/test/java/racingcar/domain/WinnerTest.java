package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

        Assertions.assertThat(Winner.findFarthestCarLocation(carList))
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

        int farthestCarPosition = Winner.findFarthestCarLocation(carList);
        Assertions.assertThat(Winner.winnerList(carList, farthestCarPosition))
                .isEqualTo(Arrays.asList("pobi", "woni"));

    }
}
