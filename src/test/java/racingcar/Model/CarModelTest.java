package racingcar.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Domain.CarGroup;

class CarModelTest {

    CarModel carModel = new CarModel();

    @Test
    @DisplayName("자동차 이름 입력에 대한 전처리 과정")
    void preProcessing() {
        //given
        String testCarNames = "car1,car2,car3";
        CarGroup expected = CarGroup.of(List.of("car1", "car2", "car3"));

        //when
        carModel.preProcessing(testCarNames);

        //then
        assertEquals(expected, carModel.preProcessing(testCarNames));
    }

    @Test
    @DisplayName("자동차 이름을 구분자로 나누는 과정")
    void divideCarNameByDelimiter() {
        //given
        String testCarNames = "car1,car2,car3";
        List<String> expected = List.of("car1", "car2", "car3");

        //when
        carModel.divideCarNameByDelimiter(testCarNames);

        //then
        assertEquals(expected, carModel.divideCarNameByDelimiter(testCarNames));
    }
}