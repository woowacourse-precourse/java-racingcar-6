package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @DisplayName("자동차 목록은 한 번 설정 추가하거나 제거할 수 없다.")
    @Test
    void testCarListImmutability() {
        // given
        List<String> carNames = List.of("Car1", "Car2", "Car3");
        cars = new Cars(carNames);

        // when
        List<Car> carList = cars.getCarList();

        // then
        assertThrows(UnsupportedOperationException.class, () -> carList.add(new Car("Car4")));
        assertThrows(UnsupportedOperationException.class, () -> carList.remove(0));
        assertEquals(3, carNames.size());
    }


    @DisplayName("자동차 이름이 유효한 경우 객체 생성를 생성한다.")
    @Test
    void constructorValidInput_test() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");

        assertDoesNotThrow(() -> new Cars(carNames));
    }

    @DisplayName("자동차 이름 중 빈 값이 있는 경우 예외를 던져 객체 생성을 막는다.")
    @Test
    void constructorInvalidInput_exception_test() {
        List<String> emptyCarNames = Arrays.asList("", "pobi");

        assertThrows(IllegalArgumentException.class, () -> new Cars(emptyCarNames));
    }

    @DisplayName("자동차 이름 중 중복이 있는 경우 예외를 던져 객체 생성을 막는다.")
    @Test
    void constructorDuplicateInput_exception_test() {
        List<String> emptyCarNames = Arrays.asList("pobi", "pobi");

        assertThrows(IllegalArgumentException.class, () -> new Cars(emptyCarNames));
    }

    @DisplayName("자동차의 목록을 List형태로 가져온다.")
    @Test
    void getCarList_test() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("Car1");
        carNames.add("Car2");
        carNames.add("Car3");
        cars = new Cars(carNames);

        // when
        List<Car> carList = cars.getCarList();

        // then
        assertNotNull(carList);
        assertEquals(3, carList.size());
    }
}