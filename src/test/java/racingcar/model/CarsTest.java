package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private Cars testCars;
    private Car testCar1;
    private Car testCar2;

    @BeforeEach
    void SetUp() {
        testCars = new Cars();
        testCar1 = new Car("testCar1", 0);
        testCar2 = new Car("testCar2", 0);
        testCars.addCar(testCar1);
        testCars.addCar(testCar2);
    }

    @Test
    void 자동차_추가_및_반환_테스트() {
        List<Car> carList = testCars.getCars();
        assertThat(carList).containsExactly(testCar1, testCar2);
    }

}
