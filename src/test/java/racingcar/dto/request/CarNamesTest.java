package racingcar.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarNameException;

class CarNamesTest {

    @Test
    @DisplayName("유효한 이름 리스트로 CarNames를 생성한다.")
    void createCarNamesByValidNameList() {

        // Given
        String name1 = "name1";
        String name2 = "n2";
        String name3 = "nme3";
        List<String> validNames = Arrays.asList(name1, name2, name3);

        // When
        CarNames carNames = CarNames.from(validNames);

        // Then
        assertEquals(validNames.size(), carNames.getNames().size());
        assertEquals(name1, carNames.getNames().get(0).name());
        assertEquals(name2, carNames.getNames().get(1).name());
        assertEquals(name3, carNames.getNames().get(2).name());
    }

    @Test
    @DisplayName("유효하지 않은 이름이 포함된 리스트로 CarNames 생성 시 InvalidCarNameException을 발생시킨다.")
    void createCarNamesByInvalidNameList() {
        // Given
        String validName = "name1";
        String invalidName = "invalidName";
        List<String> invalidNames = Arrays.asList(validName, invalidName);

        // When & Then
        assertThrows(InvalidCarNameException.class, () -> CarNames.from(invalidNames));
    }
}
