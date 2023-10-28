package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarName;

class CarsTest {

    private Cars cars;

    @DisplayName("자동차 목록은 한 번 설정 추가하거나 제거할 수 없다.")
    @Test
    void carListImmutability_test() {
        // given
        List<CarName> carNames = Arrays.asList(new CarName("Car1"), new CarName("Car2"), new CarName("Car3"));
        cars = new Cars(carNames);

        // when
        List<Car> carList = cars.getCarList();
        CarName carName = new CarName("Car4");

        // then
        assertThrows(UnsupportedOperationException.class, () -> carList.add(new Car(carName)));
        assertThrows(UnsupportedOperationException.class, () -> carList.remove(0));
        assertEquals(3, carNames.size());
    }


    @DisplayName("자동차 이름이 유효한 경우 객체 생성를 생성한다.")
    @Test
    void constructorValidInput_test() {
        List<CarName> carNames = Arrays.asList(new CarName("Car1"), new CarName("Car2"), new CarName("Car3"));

        assertDoesNotThrow(() -> new Cars(carNames));
    }

    @DisplayName("자동차 이름 중 빈 값이 있는 경우 예외를 던져 객체 생성을 막는다.")
    @Test
    void constructorInvalidInput_exception_test() {
        List<CarName> emptyCarNames = Arrays.asList(new CarName("pobi"), new CarName(""));

        assertThrows(IllegalArgumentException.class, () -> new Cars(emptyCarNames));
    }

    @DisplayName("자동차 이름 중 중복이 있는 경우 예외를 던져 객체 생성을 막는다.")
    @Test
    void constructorDuplicateInput_exception_test() {
        List<CarName> duplicateCarNames = Arrays.asList(new CarName("pobi"), new CarName("pobi"));

        assertThrows(IllegalArgumentException.class, () -> new Cars(duplicateCarNames));
    }

    @DisplayName("자동차의 목록을 List형태로 가져온다.")
    @Test
    void getCarList_test() {
        // given
        List<CarName> carNames = Arrays.asList(new CarName("Car1"), new CarName("Car2"), new CarName("Car3"));
        cars = new Cars(carNames);

        // when
        List<Car> carList = cars.getCarList();

        // then
        assertNotNull(carList);
        assertEquals(3, carList.size());
    }
}