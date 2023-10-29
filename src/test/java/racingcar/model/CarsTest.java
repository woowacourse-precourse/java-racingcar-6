package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars = new Cars();

    @Test
    void 자동차_이름이_콤마로_구분되어_저장된다() {
        //Given
        String inputString = "포비, 워니, 차니";

        //When
        cars.setCarList(inputString);
        List<Car> carList = cars.getCarList();

        //Then
        assertEquals("포비", carList.get(0).getName());
        assertEquals("워니", carList.get(1).getName());
        assertEquals("차니", carList.get(2).getName());
    }

    @Test
    void 시도_횟수_저장() {
        //Given
        String tryCount = "6";

        //When
        cars.setTryCount(tryCount);

        //Then
        assertEquals(tryCount, cars.getTryCount());
    }

    @Test
    void 시도할_횟수가_1보다_작다면_예외발생() {
        //Given
        String negativeNumber = "-1";
        String zero = "0";

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> cars.setTryCount(negativeNumber));
        assertThrows(IllegalArgumentException.class, () -> cars.setTryCount(zero));
    }

    @Test
    void 시도할_횟수가_숫자가_아니라면_예외발생() {
        //Given
        String inputValue = "sd";

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> cars.setTryCount(inputValue));
    }
}
