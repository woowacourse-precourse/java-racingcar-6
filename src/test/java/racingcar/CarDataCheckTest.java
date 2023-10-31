package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class CarDataCheckTest {
    @Test
    void 자동차_이름이_6자_이상이면_예외_발생(){
        LinkedHashMap<String, Integer> CarData = new LinkedHashMap<>();
        CarData.put("abcdef", 0);

        CarDataCheck carDataCheck = new CarDataCheck();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carDataCheck.checkCarNameIsValid(CarData);
        });
    }
}
