package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import constants.ExceptionMessage;
import java.util.List;
import org.junit.jupiter.api.Test;

class NameListValidatorTest {
    static final NameListValidator nameListValidator = new NameListValidator();

    @Test
    public void validate_제대로된_형식이면_예외없음(){
        String input = "aa,bb,ss";
        boolean isExceptionExist = false;
        try{
            nameListValidator.validate(input);
        } catch (Exception e){
            isExceptionExist = true;
        }
        assertThat(isExceptionExist).isFalse();
    }

    @Test
    public void validate_빈_값을_입력하면_예외발생(){
        String input = "";
        assertThatThrownBy(() -> nameListValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_INPUT);
    }

    @Test
    public void validate_쉼표로_끝나면_예외발생(){
        String input = "aa,bb,";
        assertThatThrownBy(() -> nameListValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ENDS_WITH_COMMA);
    }

    @Test
    public void validate_쉼표가_연달아_있으면_예외발생(){
        String input = "aa,,bb";
        assertThatThrownBy(() -> nameListValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CONTAINS_REPEATING_COMMAS);
    }

    @Test
    public void validate_이름이_최대_길이를_넘어가면_예외발생(){
        String input = "aaaaa,bbbbbb";
        assertThatThrownBy(() -> nameListValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EXCEEDED_NAME_LENGTH);
    }

    @Test
    public void validate_중복되는_이름을_입력하면_예외발생(){
        String input = "aa,bb,aa";
        assertThatThrownBy(() -> nameListValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATED_NAME);
    }

    @Test
    public void splitAndTrim_하나의_이름만_입력할_때_하나만_담긴_리스트_반환(){
        String input = "aa";
        nameListValidator.validate(input);
        List<String> carName = nameListValidator.splitAndTrim(input, ",");
        assertThat(carName.size()).isEqualTo(1);
        assertThat(carName).contains(input);
    }

    @Test
    public void splitAndTrim_쉼표_사이에_띄어쓰기가_포함되었을_때_양옆_띄어쓰기_제외하고_이름_추출(){
        String input = "aa, bbbb, ccccc ";
        nameListValidator.validate(input);
        List<String> carName = nameListValidator.splitAndTrim(input, ",");
        assertThat(carName.size()).isEqualTo(3);
        assertThat(carName).contains("aa");
        assertThat(carName).contains("bbbb");
        assertThat(carName).contains("ccccc");
    }

    @Test
    public void splitAndTrim_이름_안에_띄어쓰기가_포함되었을_때_띄어쓰기_포함하고_이름_추출(){
        String input = "a  a, b b";
        nameListValidator.validate(input);
        List<String> carName = nameListValidator.splitAndTrim(input, ",");
        assertThat(carName.size()).isEqualTo(2);
        assertThat(carName).contains("a  a");
        assertThat(carName).contains("b b");
    }
}