package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ValidatorTest {
    // TODO: Test given each element of the ArrayList is same or less than 5
    // if the input string couldn't be seperated by , delimiter, this validator would cover that.

    @Test
    void testIsNumeric(){
        Validators validator = new Validators();

        assertThat(validator.isInteger("12345")).isTrue();
        assertThat(validator.isInteger("5.05")).isFalse();
        assertThat(validator.isInteger("-200")).isFalse();
        assertThat(validator.isInteger("abc")).isFalse();
        assertThat(validator.isInteger(null)).isFalse();


    }

}
