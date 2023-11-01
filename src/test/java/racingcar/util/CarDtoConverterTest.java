package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.model.Cars;

class CarDtoConverterTest {
    @Test
    public void 유효한_Cars를_DtoList로_전환한다() {
        //given
        String carsString = "Car1, Car2, Car3";
        Cars cars = new Cars(carsString);

        //when
        List<CarDto> carDtoList = CarDtoConverter.convertCarsToCarDtoList(cars);

        //then
        assertEquals(3, carDtoList.size());
        assertEquals("Car1", carDtoList.get(0).getCarName());
        assertEquals(0, carDtoList.get(0).getMovedDistance());

        assertEquals("Car2", carDtoList.get(1).getCarName());
        assertEquals(0, carDtoList.get(1).getMovedDistance());

        assertEquals("Car3", carDtoList.get(2).getCarName());
        assertEquals(0, carDtoList.get(2).getMovedDistance());
    }
}