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

    @Test
    void 자동차이름_길이_성공_테스트() {
        racingCars.put("pobi", "");
        racingCars.put("woni", ""); // Name with length < 5

        assertDoesNotThrow(() -> Validator.inputCarNames(racingCars));
    }

    @Test
    void 자동차이름_공백_실패_테스트() {
        racingCars.put("pobi", "");
        racingCars.put("", ""); // Blank name

        assertThrows(IllegalArgumentException.class, () -> Validator.inputCarNames(racingCars));
    }

    @Test
    void 자동차이름_공백_성공_테스트() {
        racingCars.put("pobi", "");
        racingCars.put("woni", ""); // Not Blank name

        assertDoesNotThrow(() -> Validator.inputCarNames(racingCars));
    }

    @Test
    void 자동차이름_중복_실패_테스트() {
        String inputCarNames = "pobi,woni,pobi";

        assertThrows(IllegalArgumentException.class, () -> InputConvertor.toMap(inputCarNames));
    }

    @Test
    void 자동차이름_중복_성공_테스트() {
        String inputCarNames = "pobi,woni,jun";
        Map<String, String> racingCars = InputConvertor.toMap(inputCarNames);

        assertDoesNotThrow(() -> InputConvertor.toMap(inputCarNames));

        assertEquals(3, racingCars.size());
    }

}
