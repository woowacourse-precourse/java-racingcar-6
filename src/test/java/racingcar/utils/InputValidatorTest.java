package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    @Test
    void 자동차_개수는_2개_이상이어야_한다() throws Exception {
        //given
        List<String> input = Arrays.asList("pobi");
        //when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateMinCars(input));
        System.out.println(exception);
    }

    @Test
    void 자동차의_이름은_알파벳으로만_구성되야_한다() throws Exception {
        //given
        List<String> input1 = Arrays.asList("pobi", "gogo123");
        List<String> input2 = Arrays.asList("prao", " ");
        List<String> input3 = Arrays.asList("prao", "");
        //when, then
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNames(input1));
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNames(input2));
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNames(input3));
        System.out.println(exception1);
        System.out.println(exception2);
        System.out.println(exception3);
    }
    @Test
    void 자동차의_이름은_5글자_이하여야_한다() throws Exception {
        //given
        String car1 = "praoCar";
        String car2 = "aogo123";
        String car3 = "       ";
        //when, then
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNameSize(car1));
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNameSize(car2));
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNameSize(car3));
        System.out.println(exception1);
        System.out.println(exception2);
        System.out.println(exception3);
    }

}
