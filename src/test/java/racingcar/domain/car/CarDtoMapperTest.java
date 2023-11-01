package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDtoMapperTest {

    @Test
    @DisplayName("CarDto를 List<Car>에 매핑합니다.")
    void carDtoToListOfCars() {
        // GIVEN
        CarDto carDto = new CarDto("pobi,jiwoo,jiwon");
        List<Car> expected = new ArrayList<>();
        expected.add(Car.createCar("pobi", 0));
        expected.add(Car.createCar("jiwoo", 0));
        expected.add(Car.createCar("jiwon", 0));

        // WHEN
        List<Car> actual = CarDtoMapper.fromCarDto(carDto);

        // THEN
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("List<Car>를 CarDto에 매핑합니다.")
    void ListOfCarsToCarDto() {
        // GIVEN
        String pobi = "pobi";
        String jisoo = "jisoo";
        String winnerStr = pobi + ", " + jisoo;
        CarDto carDto = new CarDto(winnerStr);

        // WHEN
        List<Car> cars = CarDtoMapper.fromCarDto(carDto);

        // THEN
        assertEquals(pobi, cars.get(0).getName());
        assertEquals(jisoo, cars.get(1).getName());
    }
}