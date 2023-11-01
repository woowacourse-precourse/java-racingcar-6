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
    public void testHasAtLeastOneCharacter() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateHasAtLeastOneCharacter(""));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateHasAtLeastOneCharacter(null));
        Validator.validateHasAtLeastOneCharacter("A");
        Validator.validateHasAtLeastOneCharacter("123");
    }

    @Test
    public void testOnlyNumber() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateOnlyNumber("abc"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateOnlyNumber("123a"));
        Validator.validateOnlyNumber("1");
        Validator.validateOnlyNumber("9");
    }

    @Test
    public void testWithinRange() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateWithinRange(-1));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateWithinRange(2_147_483_647));
        Validator.validateWithinRange(0);
        Validator.validateWithinRange(2_147_483_646);
    }
}
