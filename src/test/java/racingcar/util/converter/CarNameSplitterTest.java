package racingcar.util.converter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarNameSplitterTest {

    private static final String CAR_NAME_REGEX = ",";

    @Test
    void 구분자_기준으로_올바르게_이름_추출() {
        // Given
        List<String> expectedResult = List.of("a", "b", "c");
        String carNames = String.join(CAR_NAME_REGEX, expectedResult);

        // When
        List<String> actualResult = CarNameSplitter.splitCarNames(carNames);

        // Then
        assertEquals(expectedResult.size(), actualResult.size());
        for (int nameOrder = 0; nameOrder < expectedResult.size(); nameOrder++) {
            assertEquals(expectedResult.get(nameOrder), actualResult.get(nameOrder));
        }
    }
}