package racingcar.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarNameException;

class CarNameTest {

    @Test
    @DisplayName("유효한 이름으로 CarName을 생성한다.")
    void createCarNameByValidName() {
        // Given
        String validName1 = "abc";
        String validName2 = "abcde";

        // When
        CarName carName1 = new CarName(validName1);
        CarName carName2 = new CarName(validName2);

        // Then
        assertEquals(validName1, carName1.name());
        assertEquals(validName2, carName2.name());
    }

    @Test
    @DisplayName("유효하지 않은 이름으로 CarName 생성 시 InvalidCarNameException을 발생시킨다.")
    void createCarNameByInvalidName() {
        // Given
        String invalidName = "abcdef";

        // When & Then
        assertThrows(InvalidCarNameException.class, () -> new CarName(invalidName));
    }
}
