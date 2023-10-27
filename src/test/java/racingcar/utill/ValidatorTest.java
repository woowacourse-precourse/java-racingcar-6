package racingcar.utill;

import static racingcar.utill.Validator.attemptNumberValidation;
import static racingcar.utill.Validator.carNameValidation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void carNameValidationTest() {
        //given
        String blank = "";
        String sixLength = "aaaaaa";

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameValidation(blank));
        Assertions.assertThrows(IllegalArgumentException.class, () -> carNameValidation(sixLength));
    }

    @Test
    void attemptNumberValidationTest() {
        //given
        String alphabet = "a";
        String noNatural1 = "01";
        String minus = "-1";
        String floatNumber = "0.1";

        //when , then
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptNumberValidation(alphabet));
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptNumberValidation(noNatural1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptNumberValidation(minus));
        Assertions.assertThrows(IllegalArgumentException.class, () -> attemptNumberValidation(floatNumber));
    }

}