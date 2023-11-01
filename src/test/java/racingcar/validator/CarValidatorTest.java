package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarValidatorTest {
    @Test
    public void 대문자가_포함된_경우() {
        List<String> carNameList1 = Arrays.asList("Pobi","woni");
        assertThrows(IllegalArgumentException.class, () -> CarValidator.isOnlyLowerCase(carNameList1));
        List<String> carNameList2 = Arrays.asList("pobi","woni");
        CarValidator.isOnlyLowerCase(carNameList2);
    }
}
