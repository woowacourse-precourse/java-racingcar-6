package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarFactoryTest {
    @Test
    void Cars_생성() {
        // Given: 입력 데이터
        List<String> carNames = Arrays.asList("차1", "차2", "차3");

        // When: createCars 메서드 호출
        Cars cars = CarFactory.createCars(carNames);

        // Then: 각 Car의 이름 확인
        int i = 0;
        for (Car car : cars) {
            assertEquals(carNames.get(i), car.getName().toString());
            i++;
        }
    }
}