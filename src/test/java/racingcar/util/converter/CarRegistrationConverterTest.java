package racingcar.util.converter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarRegistrationDTO;

class CarRegistrationConverterTest {

    private static final String CAR_NAME_REGEX = ",";

    @Test
    void DTO로_올바르게_변환() {
        // Given
        List<String> expectedCarNames = List.of("a", "b", "c");
        String carNames = String.join(CAR_NAME_REGEX, expectedCarNames);

        // When
        List<CarRegistrationDTO> carRegistrationDTOs = CarRegistrationConverter.convertToDTOs(carNames);

        // Then
        assertEquals(expectedCarNames.size(), carRegistrationDTOs.size());
        for (int order = 0; order < expectedCarNames.size(); order++) {
            assertEquals(expectedCarNames.get(order), carRegistrationDTOs.get(order).carName());
        }
    }
}