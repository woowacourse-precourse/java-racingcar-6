package racingcar;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ValidatorTest {
    // TODO: Test given each element of the ArrayList is same or less than 5
    // if the input string couldn't be seperated by , delimiter, this validator would cover that.
    @Test
    void testAreCarNamesOverFive() {
        Validators validator = new Validators();
        String[] testArray = "pobi,javajiww".split(",");
        ArrayList<String> testList = new ArrayList<String>(Arrays.asList(testArray));

    }

    @Test
    void testIsNumeric() {
        Validators validator = new Validators();

        assertThat(validator.isInteger("12345")).isTrue();
        assertThat(validator.isInteger("5.05")).isFalse();
        assertThat(validator.isInteger("-200")).isFalse();
        assertThat(validator.isInteger("abc")).isFalse();
        assertThat(validator.isInteger(null)).isFalse();


    }

}
