package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarsTest {
    @Test
    void 위치_값_기반으로_정렬된_리스트_반환() {
        String carNameTmp1 = "1tmp";
        String carNameTmp2 = "2tmp";
        Cars cars = new Cars();
        cars.insertCarsNames(List.of(carNameTmp1, carNameTmp2));

        List<Car> orderedCars = cars.getCarsOrderByLocations();

        Assertions.assertEquals(0, orderedCars.get(1).getLocation());
    }
}
