package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDtoMapperTest {

    @Test
    @DisplayName("CarDto를 List<Car>에 매핑합니다.")
    void mapToCar() {
        // GIVEN
        CarDto carDto = new CarDto("pobi,jiwoo,jiwon");
        List<Car> expected = new ArrayList<>();
        expected.add(Car.createCar("pobi", 0));
        expected.add(Car.createCar("jiwoo", 0));
        expected.add(Car.createCar("jiwon", 0));

        // WHEN
        List<Car> actual = CarDtoMapper.mapToCar(carDto);

        // THEN
        assertEquals(actual, expected);
    }
}