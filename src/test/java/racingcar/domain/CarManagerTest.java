package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {

    CarManager carManager = new CarManager();

    @Test
    void 자동차_객체_생성() {
        List<String> sample = Arrays.asList("현대");
        List<String> sample2 = Arrays.asList("아우디", "기아");

        List<Car> myCar = carManager.initCar(sample);
        List<Car> myCar2 = carManager.initCar(sample2);

        assertEquals(myCar2.get(1), myCar.get(1)); //아우디
    }

}