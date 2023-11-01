package racingcar.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;
import racingcar.Domain.CarGroup;

class CarModelImplTest {

    CarModelImpl carModelImpl = new CarModelImpl();

    @Test
    @DisplayName("자동차 이름 입력에 대한 전처리 과정")
    void preProcessing() {
        //given
        String testCarNames = "car1,car2,car3";
        CarGroup expected = CarGroup.of(List.of("car1", "car2", "car3"));
        CarGroup expectedCarGroup = CarGroup.of(List.of("car1", "car2", "car3"));

        //when
        carModelImpl.preProcessing(testCarNames);
        CarGroup resultCarGroup = carModelImpl.preProcessing(testCarNames);

        //then
        Integer expectedSize = expectedCarGroup.findSize();
        Integer resultSize = resultCarGroup.findSize();
        assertEquals(expectedSize, resultSize);

        for (int order = 1; order <= expectedSize; order++) {
            Car expectedCar = expectedCarGroup.findCarByOrder(order);
            Car resultCar = resultCarGroup.findCarByOrder(order);
            assertEquals(expectedCar.findName(), resultCar.findName());
        }

    }

    @Test
    @DisplayName("자동차 이름을 구분자로 나누는 과정")
    void divideCarNameByDelimiter() {
        //given
        String testCarNames = "car1,car2,car3";
        List<String> expected = List.of("car1", "car2", "car3");

        //when
        carModelImpl.divideCarNameByDelimiter(testCarNames);

        //then
        assertEquals(expected, carModelImpl.divideCarNameByDelimiter(testCarNames));
    }
}