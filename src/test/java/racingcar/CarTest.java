package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    private final static int MAX_NAME_LEGNTH = 5;

    private Car car;

    @BeforeAll
    void setUp() {
        car = new Car("name");
    }

    @Test
    public void 이름이_5글자가_넘어가는_경우_예외_발생() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("A".repeat(MAX_NAME_LEGNTH + 1));

        String invalidName = stringBuilder.toString();
        assertThrows(IllegalArgumentException.class, () -> new Car(invalidName));
    }

    @Test
    public void 이름이_5글자_이하인_경우_정상적으로_자동차가_등록() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("A".repeat(MAX_NAME_LEGNTH));

        String validName = stringBuilder.toString();
        assertDoesNotThrow(() -> new Car(validName));
    }

    @Test
    void 자동차가_전진하는_경우_location이_증가() {
        car.moveForward();
        int expected = 1;

        assertEquals(expected, car.getLastLocation());
    }


}
