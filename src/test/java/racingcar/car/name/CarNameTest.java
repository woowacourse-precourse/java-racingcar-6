package racingcar.car.name;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @DisplayName("CarName 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"car", "race", "speed", "auto", "a"})
    void createCarName_success(String name) {
        assertDoesNotThrow(() -> new CarName(name));
    }

    @DisplayName("CarName 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"", "Car1", "racingcar", "Race", "carname", "12345", "     "})
    void createCarName_failure(String name) {
        assertThrows(IllegalArgumentException.class, () -> new CarName(name));
    }
}
