package racingcar.util.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameContainsWhiteSpaceException;
import racingcar.exception.CarNameDuplicatedException;
import racingcar.exception.CarNameLengthInvalidException;
import racingcar.exception.NoCarNameException;
import racingcar.exception.UserInputIsNullException;

class CarNamesValidatorTest {

    private static final String EMPTY_CAR_NAME = "";
    private static final String INPUT_WITHOUT_CAR_NAME = ",,,";
    private static final String NAME_LENGTH_INVALID = "123456";
    private static final String INPUT_WITH_EMPTY_NAME = "1,,2";
    private static final String NAME_CONTAINS_WHITESPACE = "1,3 3,2";
    private static final String CONTAINS_DUPLICATED_NAME = "1,1,3";

    @Test
    void 공백_입력_시_예외_발생() {
        assertThrows(UserInputIsNullException.class,
                () -> CarNamesValidator.validate(EMPTY_CAR_NAME));
    }

    @Test
    void 입력에_구분자만_있을_경우_예외_발생() {
        assertThrows(NoCarNameException.class,
                () -> CarNamesValidator.validate(INPUT_WITHOUT_CAR_NAME));
    }

    @Test
    void 이름의_길이가_허용범위를_넘은_경우_예외_발생() {
        assertThrows(CarNameLengthInvalidException.class,
                () -> CarNamesValidator.validate(NAME_LENGTH_INVALID));
    }

    @Test
    void 이름의_길이가_0일_경우_예외_발생() {
        assertThrows(CarNameLengthInvalidException.class,
                () -> CarNamesValidator.validate(INPUT_WITH_EMPTY_NAME));
    }

    @Test
    void 이름에_공백이_포함된_경우_예외_발생() {
        assertThrows(CarNameContainsWhiteSpaceException.class,
                () -> CarNamesValidator.validate(NAME_CONTAINS_WHITESPACE));
    }

    @Test
    void 중복된_이름이_있을_경우_예외_발생() {
        assertThrows(CarNameDuplicatedException.class,
                () -> CarNamesValidator.validate(CONTAINS_DUPLICATED_NAME));
    }
}