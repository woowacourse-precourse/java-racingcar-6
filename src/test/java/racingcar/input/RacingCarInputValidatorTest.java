package racingcar.input;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.input.RacingCarInputValidator.hasDuplicatedName;
import static racingcar.input.RacingCarInputValidator.hasLongName;
import static racingcar.input.RacingCarInputValidator.isInputRacingCarsValidated;

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
}