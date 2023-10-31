package racingcar.utill;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.utill.Validator.validateAttemptNumber;
import static racingcar.utill.Validator.validateCarName;
import static racingcar.utill.Validator.validateDuplicatedCarName;
import static racingcar.utill.Validator.validateNullInput;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class ValidatorTest {

    @Test
    void validateNullInputTest() {
        //given
        String nullString = null;

        //when, then
        assertThrows(IllegalArgumentException.class, () -> validateNullInput(nullString));
    }

    @Test
    void ValidateCarNameTest() {
        //given
        String blank1 = "";
        String blank2 = " ";
        String sixLength = "aaaaaa";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> validateCarName(blank1));
        assertThrows(IllegalArgumentException.class, () -> validateCarName(blank2));
        assertThrows(IllegalArgumentException.class, () -> validateCarName(sixLength));
    }

    @Test
    void validateAttemptNumberTest() {
        //given
        String alphabet = "a";
        String noNatural1 = "01";
        String minus = "-1";
        String floatNumber = "0.1";

        //when , then
        assertThrows(IllegalArgumentException.class, () -> validateAttemptNumber(alphabet));
        assertThrows(IllegalArgumentException.class, () -> validateAttemptNumber(noNatural1));
        assertThrows(IllegalArgumentException.class, () -> validateAttemptNumber(minus));
        assertThrows(IllegalArgumentException.class, () -> validateAttemptNumber(floatNumber));
    }

    @Test
    void validateDuplicatedCarNameTest() {
        //given
        List<Car> testCarList = new ArrayList<>();
        Car winnerCar = new Car("zizi");
        winnerCar.move(5);
        testCarList.add(winnerCar);
        testCarList.add(new Car("hoho"));
        testCarList.add(new Car("haha"));
        testCarList.add(new Car("haha"));

        //when, then
        assertThrows(IllegalArgumentException.class, () -> validateDuplicatedCarName(testCarList));

    }

}