package racingcar.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    void 아무런_자동차도_없을_때_예외_발생() {

        //given
        String carsInput1 = ",,,";
        String carsInput2 = "";

        String[] split1 = carsInput1.split(",", -1);
        String[] split2 = carsInput2.split(",", -1);

        //then
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateCarsName(split1));
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateCarsName(split2));
    }

    @Test
    void 중간에_이름없는_문자열이_들어왔을_때_예외_발생() {

        //given
        String carsInput1 = "tobi,,";
        String carsInput2 = ",tobi,";
        String carsInput3 = ",,tobi";

        String[] split1 = carsInput1.split(",", -1);
        String[] split2 = carsInput2.split(",", -1);
        String[] split3 = carsInput3.split(",", -1);

        //then
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateCarsName(split1));
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateCarsName(split2));
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateCarsName(split3));
    }

    @Test
    void 이름이_5글자가_넘는_문자열이_들어왔을_때_예외_발생() {

        //given
        String carsInput1 = "tobiww,woni,jazy";
        String carsInput2 = "tobi,wonyzz,jazy";
        String carsInput3 = "tobi,wony,jazyww";

        String[] split1 = carsInput1.split(",", -1);
        String[] split2 = carsInput2.split(",", -1);
        String[] split3 = carsInput3.split(",", -1);


        //then
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateCarsName(split1));
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateCarsName(split2));
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateCarsName(split3));
    }

    @Test
    void 시도할_횟수에_0에서_9가_아닌_다른_문자가_들어왔을_때_예외_발생(){

        //given
        String timesInput1 = "qks";
        String timesInput2 = ".123";
        String timesInput3 = "12k3";

        // then
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateTimes(timesInput1));
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateTimes(timesInput2));
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateTimes(timesInput3));
    }
}