package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    @Test
    public void testNoSpacesBetweenCommas() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNoSpacesBetweenCommas("a, b, c"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNoSpacesBetweenCommas("1 ,2,3"));
        Validator.validateNoSpacesBetweenCommas("x,y,z");
        Validator.validateNoSpacesBetweenCommas("dy car,jy car,ky car");
    }

    @Test
    public void testNameLength() {
//        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameLength(""));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameLength("abcdefg"));
        Validator.validateNameLength("A");
        Validator.validateNameLength("123");
    }

    @Test
    public void testOnlyNumber() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateOnlyNumber("abc"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateOnlyNumber("123a"));
        Validator.validateOnlyNumber("1");
        Validator.validateOnlyNumber("9");
    }

    @Test
    public void testWithinIntegerRange() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateWithinIntegerRange(-1));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateWithinIntegerRange(2_147_483_647));
        Validator.validateWithinIntegerRange(0);
        Validator.validateWithinIntegerRange(2_147_483_646);
    }
}
