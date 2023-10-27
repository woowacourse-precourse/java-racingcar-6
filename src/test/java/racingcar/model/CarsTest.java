package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("사용자 상태 출력 테스트")
    void carStatusTest() {
        String expectKimStatus = "kim : ";

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("kim"));

        Cars cars = new Cars(carList);
        List<String> carStatusList = cars.getCarStatusList();
        String actualKimStatus = carStatusList.get(0);

        assertThat(actualKimStatus).isEqualTo(expectKimStatus);
    }

    @Test
    @DisplayName("사용자 전진 상태 출력 테스트")
    void carForwardStatusTest() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("kim"));

        Cars cars = new Cars(carList);
        for (int i = 0; i < 1000; i++) {
            cars.move();
        }

        List<String> carStatusList = cars.getCarStatusList();
        String actualKimStatus = carStatusList.get(0);

        assertThat(actualKimStatus.contains("-")).isTrue();
    }

    @Test
    @DisplayName("우승자 리스트 테스트")
    void winnerListTest() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("kim"));
        carList.add(new Car("lee"));
        carList.add(new Car("park"));

        Cars cars = new Cars(carList);
        for (int i = 0; i < 100; i++) {
            cars.move();
        }

        List<String> winnerList = cars.getWinnerList();
        assertThat(winnerList.size()).isGreaterThanOrEqualTo(1);
    }

}