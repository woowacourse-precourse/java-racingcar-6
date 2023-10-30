package racingcar.vo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    private static final Integer CAR_NAME_MAX_LENGTH = 5;

    @DisplayName("유효한 자동차 이름인 경우 예외가 발생하지 않고 레코드가 정상적으로 생성된다.")
    @Test
    void validCarName_test() {
        String validName = "a".repeat(CAR_NAME_MAX_LENGTH);

        CarName carName = assertDoesNotThrow(() -> {
            return new CarName(validName);
        });
        assertEquals(validName, carName.name());
    }

    @DisplayName("자동차 이름이 6자 이상인 경우 예외가 발생한다.")
    @Test
    void invalidCarName_exception_test() {
        String invalidName = "a".repeat(CAR_NAME_MAX_LENGTH + 1);

        assertThrows(IllegalArgumentException.class, () -> new CarName(invalidName));
    }

    @DisplayName("필드값이 동일하면 레코드는 동일하다.")
    @Test
    void carName_equal_test() {
        CarName carName1 = new CarName("pobi");
        CarName carName2 = new CarName("pobi");

        assertEquals(carName1, carName2);
    }

    @DisplayName("필드값이 동일하지 않으면 레코드는 동일하지 않다.")
    @Test
    void carName_not_equal_test() {
        CarName carName1 = new CarName("pobi");
        CarName carName2 = new CarName("kdo");

        assertNotEquals(carName1, carName2);
    }
}
