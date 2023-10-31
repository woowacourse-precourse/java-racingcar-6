package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Cars 테스트")
public class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성 및 이동 테스트")
    void testCreateAndMoveCars() {
        // Cars 객체 생성
        CarName carName1 = new CarName("Car1");
        CarName carName2 = new CarName("Car2");
        CarName carName3 = new CarName("Car3");

        Cars cars = new Cars(Arrays.asList(new Car(carName1), new Car(carName2), new Car(carName3)));

        NumberGenerator numberGenerator = () -> 4;

        // 이동
        cars.moveAll(numberGenerator);

        // 이동 후 위치 확인
        Map<String, Integer> racingStatus = cars.getRacingStatus();
        assertEquals(1, racingStatus.get("Car1"));
        assertEquals(1, racingStatus.get("Car2"));
        assertEquals(1, racingStatus.get("Car3"));
    }

    @Test
    @DisplayName("Cars 객체 생성 시 최소 자동차 수 미달로 실패하는 테스트")
    void testCreateCarsWithInsufficientCount() {
        // 최소 자동차 수 미달로 Cars 객체 생성 시 예외가 발생해야 함
        assertThrows(IllegalArgumentException.class, () ->
                new Cars(Arrays.asList(new Car(new CarName("Car1")))));
    }

    @Test
    @DisplayName("Cars 객체 생성 시 중복 자동차 이름으로 실패하는 테스트")
    void testCreateCarsWithDuplicateCarName() {
        // 중복된 자동차 이름으로 Cars 객체 생성 시 예외가 발생해야 함
        assertThrows(IllegalArgumentException.class, () ->
                new Cars(Arrays.asList(new Car(new CarName("Car1")),new Car(new CarName("Car1")))));
    }
}
