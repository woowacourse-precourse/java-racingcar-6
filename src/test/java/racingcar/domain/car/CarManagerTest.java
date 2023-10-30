package racingcar.domain.car;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarManagerTest {
    @Test
    @DisplayName("자동차 이름을 파싱하면 Car 객체의 리스트를 반환한다")
    void parseCarNames_ReturnsListOfCars() {
        // Given
        String input = "car1,car2,car3";

        // When
        CarManager carManager = new CarManager(input,()->true);

        // Then
        assertThat(carManager.getCars()).hasSize(3)
                .extracting("name")
                .containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외를 던진다")
    void parseCarNames_WithDuplicateNames_ThrowsException() {
        // Given
        String input = "car1,car2,car1";

        // When, Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            CarManager carManager = new CarManager(input, () -> true);
        });

        assertThat(thrown).hasMessageContaining("중복된 자동차 이름이 있습니다");
    }
}
