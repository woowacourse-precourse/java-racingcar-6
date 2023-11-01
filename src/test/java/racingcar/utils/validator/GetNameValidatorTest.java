package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.validator.GetNameValidator.BLANK_ERROR_MESSAGE;
import static racingcar.utils.validator.GetNameValidator.CARS_NUMBER_ERROR_MESSAGE;
import static racingcar.utils.validator.GetNameValidator.COMMA_POSITION_ERROR_MESSAGE;
import static racingcar.utils.validator.GetNameValidator.DIGIT_ERROR_MESSAGE;
import static racingcar.utils.validator.GetNameValidator.DUPLICATE_ERROR_MESSAGE;
import static racingcar.utils.validator.GetNameValidator.NOT_FORMAT_ERROR_MESSAGE;
import static racingcar.utils.validator.GetNameValidator.validateArrayListNames;
import static racingcar.utils.validator.GetNameValidator.validateStringNames;

import java.util.ArrayList;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class GetNameValidatorTest {

    @Test
    void 이름_공백_예외처리() {
        String input = "abc,asd fas,df df";

        assertThatThrownBy(() -> validateStringNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK_ERROR_MESSAGE);
    }

    @Test
    void 이름_콤마위치_예외처리() {
        String input1 = "abc,";
        String input2 = ",abc";

        assertThatThrownBy(() -> validateStringNames(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COMMA_POSITION_ERROR_MESSAGE);

        assertThatThrownBy(() -> validateStringNames(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COMMA_POSITION_ERROR_MESSAGE);
    }

    @Test
    void 이름_지정되지_않은문자_예외처리() {
        String input = "@#ab,2322,!@312";

        assertThatThrownBy(() -> validateStringNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_FORMAT_ERROR_MESSAGE);
    }

    @Test
    void 이름_5글자_이상_예외처리() {
        String[] stringArray = {"abc", "asdfas", "dfdf"};
        ArrayList<String> stringArrayList = Lists.newArrayList(stringArray);

        assertThatThrownBy(() -> validateArrayListNames(stringArrayList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_ERROR_MESSAGE);
    }

    @Test
    void 이름_중복_예외처리() {
        String[] stringArray = {"abc", "abc", "dfdf"};
        ArrayList<String> stringArrayList = Lists.newArrayList(stringArray);
        assertThatThrownBy(() -> validateArrayListNames(stringArrayList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    void 이름_2개이하_예외처리() {
        String[] stringArray = {"abc"};
        ArrayList<String> stringArrayList = Lists.newArrayList(stringArray);
        assertThatThrownBy(() -> validateArrayListNames(stringArrayList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CARS_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 이름_입력없음_예외처리() {
        String[] stringArray = {""};
        ArrayList<String> stringArrayList = Lists.newArrayList(stringArray);

        assertThatThrownBy(() -> validateArrayListNames(stringArrayList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_ERROR_MESSAGE);
    }

    @Test
    void 이름_1자_미만_예외처리() {
        String[] stringArray = {"abd,,dfdf"};
        ArrayList<String> stringArrayList = Lists.newArrayList(stringArray);

        assertThatThrownBy(() -> validateArrayListNames(stringArrayList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIGIT_ERROR_MESSAGE);
    }

}