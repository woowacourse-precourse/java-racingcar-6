package racingcar.ModelTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

public class CarTest {

    @Test
    @DisplayName("5글자 이상 유효성검사 테스트")
    public void validCarNameTest() {
        String invalidName = "genesis";
        String validName = "tico";

        assertThrows(IllegalArgumentException.class ,() -> new Car(invalidName));
        assertDoesNotThrow(() -> new Car(validName));
    }
}
