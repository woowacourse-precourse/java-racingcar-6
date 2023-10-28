package racingcar.input;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.input.RacingCarInputValidator.hasDuplicatedName;
import static racingcar.input.RacingCarInputValidator.hasLongName;
import static racingcar.input.RacingCarInputValidator.hasUnderValue;
import static racingcar.input.RacingCarInputValidator.isInputPlayNumberValidated;
import static racingcar.input.RacingCarInputValidator.isInputRacingCarsValidated;
import static racingcar.input.RacingCarInputValidator.isUnavailableToParseInteger;

import org.junit.jupiter.api.Test;

class RacingCarInputValidatorTest {

    @Test
    public void hasDuplicatedName_notDuplicated_false() {
        // given
        String[] names = {
          "test1",
          "test2",
          "test3"
        };

        // when
        boolean result = hasDuplicatedName(names);

        // then
        assertFalse(result);
    }

    @Test
    public void hasDuplicatedName_duplicated_true() {
        // given
        String[] names = {
                "test1",
                "test1",
                "test2"
        };

        // when
        boolean result = hasDuplicatedName(names);

        // then
        assertTrue(result);
    }

    @Test
    public void hasLongName_hasLongName_true() {
        // given
        String[] names = {
                "test1",
                "test2",
                "LongTest3"
        };

        // when
        boolean result = hasLongName(names);

        // then
        assertTrue(result);
    }

    @Test
    public void hasLongName_available_true() {
        // given
        String[] names = {
                "test1",
                "test2",
                "test3"
        };

        // when
        boolean result = hasLongName(names);

        // then
        assertFalse(result);
    }

    @Test
    public void isInputRacingCarsValidated_available_true() {
        // given
        String input = "test1,test2,test3";

        // when
        boolean result = isInputRacingCarsValidated(input);

        // then
        assertTrue(result);
    }

    @Test
    public void isInputRacingCarsValidated_unavailable_hasLongName_false() {
        // given
        String input = "test1,test2,LongTest3";

        // when
        boolean result = isInputRacingCarsValidated(input);

        // then
        assertFalse(result);
    }

    @Test
    public void isInputRacingCarsValidated_unavailable_hasDuplicated_false() {
        // given
        String input = "test1,test1,test2";

        // when
        boolean result = isInputRacingCarsValidated(input);

        // then
        assertFalse(result);
    }

    @Test
    public void isUnavailableToParseInteger_unavailable_true() {
        // given
        String input = "12a";

        // when
        boolean result = isUnavailableToParseInteger(input);

        // then
        assertTrue(result);
    }

    @Test
    public void isUnavailableToParseInteger_available_false() {
        // given
        String input = "123";

        // when
        boolean result = isUnavailableToParseInteger(input);

        // then
        assertFalse(result);
    }

    @Test
    public void hasUnderValue_undervalue_true() {
        // given
        String input = "-1";

        // when
        boolean result = hasUnderValue(input);

        // then
        assertTrue(result);
    }

    @Test
    public void hasUnderValue_overValue_false() {
        // given
        String input = "1";

        // when
        boolean result = hasUnderValue(input);

        // then
        assertFalse(result);
    }

    @Test
    public void isInputPlayNumberValidated_available_true() {
        // given
        String input = "123";

        // when
        boolean result = isInputPlayNumberValidated(input);

        // then
        assertTrue(result);
    }

    @Test
    public void isInputPlayNumberValidated_underValue_false() {
        // given
        String input = "0";

        // when
        boolean result = isInputPlayNumberValidated(input);

        // then
        assertFalse(result);
    }

    @Test
    public void isInputPlayNumberValidated_notParse_false() {
        // given
        String input = "a";

        // when
        boolean result = isInputPlayNumberValidated(input);

        // then
        assertFalse(result);
    }
}