package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class GetNameValidatorTest {


    @Test
    void 이름_공백_예외처리() {
        String input = "abc,asd fas,df df";

        assertThatThrownBy(() -> GetNameValidator.validateStringNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백");
    }

    @Test
    void 이름_콤마위치_예외처리() {
        String input1 = "abc,";
        String input2 = ",abc";

        assertThatThrownBy(() -> GetNameValidator.validateStringNames(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("위치");

        assertThatThrownBy(() -> GetNameValidator.validateStringNames(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("위치");


    }

    @Test
    void 이름_지정되지_않은문자_예외처리() {
        String input = "@#ab,2322,!@312";

        assertThatThrownBy(() -> GetNameValidator.validateStringNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자, 숫자");
    }

    @Test
    void 이름_5글자_이상_예외처리() {
        String[] stringArray = {"abc","asdfas","dfdf"};
        ArrayList<String> stringArrayList = Lists.newArrayList(stringArray);

        assertThatThrownBy(() -> GetNameValidator.validateArrayListNames(stringArrayList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5");
    }

    @Test
    void 이름_중복_예외처리() {
        String[] stringArray = {"abc","abc","dfdf"};
        ArrayList<String> stringArrayList = Lists.newArrayList(stringArray);
        assertThatThrownBy(() -> GetNameValidator.validateArrayListNames(stringArrayList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    void 이름_2개이하_예외처리() {
        String[] stringArray = {"abc"};
        ArrayList<String> stringArrayList = Lists.newArrayList(stringArray);
        assertThatThrownBy(() -> GetNameValidator.validateArrayListNames(stringArrayList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("2개");
    }

    @Test
    void 이름_입력없음_예외처리() {
        String[] stringArray = {""};
        ArrayList<String> stringArrayList = Lists.newArrayList(stringArray);

        assertThatThrownBy(() -> GetNameValidator.validateArrayListNames(stringArrayList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("2개");
    }


}