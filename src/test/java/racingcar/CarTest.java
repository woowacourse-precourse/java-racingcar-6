package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarTest {

    private final static int MAX_NAME_LEGNTH = 5;

    @Test
    public void 이름이_5글자가_넘어가는_경우_예외_발생() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("A".repeat(MAX_NAME_LEGNTH + 1));

        String invalidName = stringBuilder.toString();
        assertThrows(IllegalArgumentException.class, () -> Car.getInstance(invalidName));
    }

    @Test
    public void 이름이_5글자_이하인_경우_정상적으로_자동차가_등록() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("A".repeat(MAX_NAME_LEGNTH));

        String validName = stringBuilder.toString();
        assertDoesNotThrow(() -> Car.getInstance(validName));
    }
}
