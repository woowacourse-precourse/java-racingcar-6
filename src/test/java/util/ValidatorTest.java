package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 올바른_자동차_이름() {
        String validNames = "Car1,Car2,Car3";
        List<String> result = Validator.validateCarNames(validNames);
        assertEquals(Arrays.asList("Car1", "Car2", "Car3"), result);
    }
    @Test
    void 올바르지않은_다섯자_이상의_이름() {
        String invalidNames = "Car1,Car2,Car345";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(invalidNames));
    }

    @Test
    void 올바르지않은_중복된_이름() {
        String duplicateNames = "Car1,Car2,Car3,Car1";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(duplicateNames));
    }
    @Test
    void 올바른_횟수() {
        String validTrial = "10";
        int result = Validator.validateTrial(validTrial);
        assertEquals(10, result);
    }

    @Test
    void 올바르지않은_음수_횟수() {
        String negativeTrial = "-5";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateTrial(negativeTrial));
    }

    @Test
    void 올바르지않은_초과_횟수(){
        String largeTrial = "2000";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateTrial(largeTrial));
    }

    @Test
    void 올바르지않은_숫자가_아닌_횟수(){
        String nonNumericTrial = "abc";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateTrial(nonNumericTrial));
    }
}
