package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.Car;
import racingcar.service.CarCreator;

public class CarCreatorTest {

    @Test
    void 객체_생성() {
        // given
        CarCreator carCreator = new CarCreator();
        List<String> rangeCarList = Arrays.asList("Car1", "Car2", "Car3");
        int distance = 100;

        // when
        List<Car> cars = carCreator.createCars(rangeCarList, distance);

        // then
        assertEquals(3, cars.size(), "Car 리스트의 크기가 3이어야 합니다.");
        for (int i = 0; i < rangeCarList.size(); i++) {
            assertEquals(rangeCarList.get(i), cars.get(i).getName(), "Car 이름이 일치해야 합니다.");
            assertEquals(distance, cars.get(i).getDistance(), "Car 거리가 일치해야 합니다.");
        }
    }
}
