package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarDtoMapperTest {

    @Test
    void mapToCar() {
        // GIVEN
        CarDto carDto = new CarDto("pobi,jiwoo,jiwon");

        // WHEN
        List<Car> cars = CarDtoMapper.mapToCar(carDto);

        // THEN
        assertEquals(cars.get(1).getName(), "jiwoo");
        assertEquals(cars.get(2).getName(), "jiwon");

        assertEquals(cars.get(0).getCurrentLocation(), 0);
        assertEquals(cars.get(1).getCurrentLocation(), 0);
        assertEquals(cars.get(2).getCurrentLocation(), 0);
    }
}