package racingcar.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.vo.CarName;

class CarDtoTest {

    @DisplayName("Cars를 CarDto 목록으로 변환한다.")
    @Test
    void toDtoList_test() {
        // given
        List<CarName> carNames = Arrays.asList(new CarName("Car1"), new CarName("Car2"));
        Cars cars = new Cars(carNames);

        // when
        List<CarDto> carDtoList = CarDto.toDtoList(cars);

        // then
        assertEquals(2, carDtoList.size());

        assertEquals("Car1", carDtoList.get(0).getCarName());
        assertEquals(0, carDtoList.get(0).getPosition());

        assertEquals("Car2", carDtoList.get(1).getCarName());
        assertEquals(0, carDtoList.get(1).getPosition());
    }
}
