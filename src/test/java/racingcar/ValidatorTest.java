package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.HashMap;

public class ValidatorTest {
    private Map<String, String> racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new HashMap<>();
    }

    @Test
    void 자동차이름_길이_실패_테스트() {
        racingCars.put("pobi", "");
        racingCars.put("woniiii", ""); // Name with length > 5

        assertThrows(IllegalArgumentException.class, () -> Validator.inputCarNames(racingCars));
    }
}
