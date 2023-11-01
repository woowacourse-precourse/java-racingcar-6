package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

class ValidatorTest {
    @Test
    public void Car1_Car2_는_유효하다() {
        String successCarsString = "Car1, Car2";
        Cars successCars = new Cars(successCarsString);
        Validator.validateCars(successCars);
    }

    @Test
    public void 이름이_하나이면_예외를던진다() {

        Cars carSizeOne = new Cars("Car1");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCars(carSizeOne));
    }

    @Test
    public void 이름의_길이가_5이상이면_예외를던진다() {
        Cars carLongName = new Cars("CarLongLength, car2, car3");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCars(carLongName));
    }

    @Test
    public void 이름이_중복되면_예외를던진다() {
        Cars carDuplicateName = new Cars("car1, car2, car2");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCars(carDuplicateName));
    }
    @Test
    public void 유효한_정수값을_반환한다() {
        String validNumber = "5";
        assertEquals(5, Validator.validateNumber(validNumber));
    }

    @Test
    public void 정수가_아니라면_예외를던진다() {
        String invalidFormat = "invalid";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNumber(invalidFormat));
    }

    @Test
    public void 정수가_0이라면_예외를던진다() {
        String zeroNumber = "0";
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNumber(zeroNumber));
    }
}