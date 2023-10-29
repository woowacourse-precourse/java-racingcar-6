package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarTest {

    @Test
    void 자동차_이름이_콤마로_구분되어_저장된다() {
        //Given
        Cars cars = new Cars();
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
    void 이름이_NULL이거나_길이가_범위를_벗어나면_예외발생() {
        //Given
        String shortName = "";
        String LongName = "마다가스카르";

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
        assertThrows(IllegalArgumentException.class, () -> new Car(shortName));
        assertThrows(IllegalArgumentException.class, () -> new Car(LongName));
    }
}
