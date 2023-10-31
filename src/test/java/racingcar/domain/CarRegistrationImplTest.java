package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarRegistrationDTO;

class CarRegistrationImplTest {

    @Test
    void 자동차를_올바르게_등록() {
        // Given
        List<String> carNames = List.of("aa", "bb", "cc");
        List<CarRegistrationDTO> carRegistrationDTOs = carNames.stream()
                .map(CarRegistrationDTO::new)
                .collect(Collectors.toList());

        // When
        List<Car> cars = new CarRegistrationImpl().register(carRegistrationDTOs);

        // Then
        assertEquals(carNames.size(), cars.size());
    }
}