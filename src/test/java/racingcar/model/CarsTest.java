package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("입력받은 이름을 List형태로 잘 변환하는지 테스트")
    public void testCreateCars() {
        String[] carNames = {"Car1", "Car2", "Car3"};
        Cars cars = new Cars(carNames);
        List<Car> carList = cars.getCars();

        assertEquals(carNames.length, carList.size());
        for (int i = 0; i < carNames.length; i++) {
            assertEquals(carNames[i], carList.get(i).getName());
        }
    }
}