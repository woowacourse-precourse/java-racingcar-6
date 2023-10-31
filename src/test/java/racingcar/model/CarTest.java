package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class CarTest{

    @Test
    @DisplayName("초기 자동차의 위치는 0이어야 한다")
    void initCar() {
        // when
        Car car = new Car();
        car.initCar(Arrays.asList("pobi","woni","jun"));
        Map<String, Integer> carData = car.getCarData();
        // then
        Assertions.assertThat(carData.values()).allMatch(v -> v == 0);
    }

    @Test
    @DisplayName("전진은 한칸 혹은 제자리여야한다")
    void move() {
        // given
        Car car = new Car();
        car.initCar(Arrays.asList("pobi"));
        // when
        car.move();
        // then
        int position = car.getCarData().get("pobi");
        org.junit.jupiter.api.Assertions.assertTrue(position == 1 || position == 0);
    }

    @Test
    @DisplayName("pobi가 제일 많이 전진했을 때 pobi가 우승자여야 한다")
    void findWinnerTest() {
        // given
        Car car = new Car();
        List<String> carNames = Arrays.asList("pobi", "woni");
        List<String> expected = Arrays.asList("pobi");
        car.initCar(carNames);

        car.getCarData().replace("pobi", 4);
        car.getCarData().replace("woni", 2);

        // when
        List<String> actual = car.findWinners();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("pobi, woni가 동일한 위치 일 경우 ['pobi', 'woni']를 반환해야한다")
    void findWinnersTest() {
        // given
        Car car = new Car();
        List<String> carNames = Arrays.asList("pobi", "woni");
        List<String> expected = Arrays.asList("pobi", "woni");
        car.initCar(carNames);

        car.getCarData().replace("pobi", 4);
        car.getCarData().replace("woni", 4);

        // when
        List<String> actual = car.findWinners();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}