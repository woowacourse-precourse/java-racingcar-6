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
        assertThrows(IllegalArgumentException.class, () -> CarValidator.checkUpperCase(carNameList1));
        List<String> carNameList2 = Arrays.asList("pobi","woni");
        CarValidator.checkUpperCase(carNameList2);
    }

    @Test
    public void 이름이_다섯자리_초과인_경우() {
        List<String> carNameList1 = Arrays.asList("suhyun","woni");
        assertThrows(IllegalArgumentException.class, () -> CarValidator.checkCarNameLength(carNameList1));
        List<String> carNameList2 = Arrays.asList("pobi","woni");
        CarValidator.checkCarNameLength(carNameList2);
    }

    @Test
    public void 이름이_중복인_경우() {
        List<String> carNameList1 = Arrays.asList("woni","woni");
        assertThrows(IllegalArgumentException.class, () -> CarValidator.checkDuplicateCarName(carNameList1));
        List<String> carNameList2 = Arrays.asList("pobi","woni");
        CarValidator.checkDuplicateCarName(carNameList2);
    }
}
