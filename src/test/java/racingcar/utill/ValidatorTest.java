package racingcar.utill;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.utill.Validator.attemptNumberValidation;
import static racingcar.utill.Validator.carNameValidation;
import static racingcar.utill.Validator.duplicateCarNameValidation;
import static racingcar.utill.Validator.nullInputValidation;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class ValidatorTest {

    @Test
    void nullInputValidationTest() {
        //given
        String nullString = null;

        //when, then
        assertThrows(IllegalArgumentException.class, () -> nullInputValidation(nullString));
    }

    @Test
    void carNameValidationTest() {
        //given
        String blank1 = "";
        String blank2 = " ";
        String sixLength = "aaaaaa";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> carNameValidation(blank1));
        assertThrows(IllegalArgumentException.class, () -> carNameValidation(blank2));
        assertThrows(IllegalArgumentException.class, () -> carNameValidation(sixLength));
    }

    @Test
    void attemptNumberValidationTest() {
        //given
        String alphabet = "a";
        String noNatural1 = "01";
        String minus = "-1";
        String floatNumber = "0.1";

        //when , then
        assertThrows(IllegalArgumentException.class, () -> attemptNumberValidation(alphabet));
        assertThrows(IllegalArgumentException.class, () -> attemptNumberValidation(noNatural1));
        assertThrows(IllegalArgumentException.class, () -> attemptNumberValidation(minus));
        assertThrows(IllegalArgumentException.class, () -> attemptNumberValidation(floatNumber));
    }

    @Test
    void duplicateCarNameValidationTest() {
        //given
        List<Car> testCarList = new ArrayList<>();
        Car winnerCar = new Car("zizi");
        winnerCar.decisionMoveOrStop(5);
        testCarList.add(winnerCar);
        testCarList.add(new Car("hoho"));
        testCarList.add(new Car("haha"));
        testCarList.add(new Car("haha"));

        //when, then
        assertThrows(IllegalArgumentException.class, () -> duplicateCarNameValidation(testCarList));

    }

}