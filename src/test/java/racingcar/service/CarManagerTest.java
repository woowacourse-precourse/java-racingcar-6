package racingcar.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.RandomCalculator;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.entry;
import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {
    RandomCalculator randomCalculator = new RandomCalculator();

    @Test
    public void 생성자_carList_테스트() {
        CarManager carManager = new CarManager("가나,다라,마바");


        Assertions.assertThat(carManager.getCarList()).hasSize(3)
                .contains("가나", "다라", "마바");

    }

    @Test
    public void 생성자_carMap_테스트() {
        CarManager carManager = new CarManager("가나,다라,마바");
        HashMap<String, Car> carMap = carManager.getCarMap();

        Assertions.assertThat(carMap.get("가나").getPosition()).isZero();
        Assertions.assertThat(carMap.get("다라").getPosition()).isZero();
        Assertions.assertThat(carMap.get("마바").getPosition()).isZero();

    }

    @Test
    public void go테스트() {
        CarManager carManager = new CarManager("가나,다라,마바");
        HashMap<String, Car> carMap = carManager.getCarMap();
        carMap.get("가나").go();
        Assertions.assertThat(carMap.get("가나").getPosition()).isEqualTo(1);

    }
    @Test
    public void WinnerList테스트() {
        CarManager carManager = new CarManager("가나,다라,마바");
        HashMap<String, Car> carMap = carManager.getCarMap();

        Assertions.assertThat(carManager.getWinnerList()).contains("가나","다라","마바");





    }
}