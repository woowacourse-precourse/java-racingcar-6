package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();
    
    @Test
    @DisplayName("차 이름 입력 - 실패(입력이 빈칸)")
    public void inputCarNamesValueIsBlank() throws Exception {
        //given
        String inputCarNames = "";
        //when - then
        assertThatThrownBy(() -> inputValidator.validateInputCarName(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("차 이름 입력 - 실패(,로 끝날 시)")
    public void inputCarNamesValueLastIsComma() throws Exception {
        //given
        String inputCarNames = "hi,";
        //when - then
        assertThatThrownBy(() -> inputValidator.validateInputCarName(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("쉼표(,)는 이름 구분 용도로 사용해주세요.");
    }

    @Test
    @DisplayName("차 이름 입력 - 실패(5글자 초과)")
    public void inputCarNameValueOverLength() throws Exception {
        //given
        String inputCarNames = "123456";
        //when - then
        assertThatThrownBy(() -> inputValidator.validateInputCarName(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 글자수는 " + 5 + "입니다.");
    }

    @Test
    @DisplayName("차 이름 입력 - 실패(1글자 미만)")
    public void inputCarNameValueUnderLength() throws Exception {
        //given
        String inputCarNames = "hi,,bye";
        //when - then
        assertThatThrownBy(() -> inputValidator.validateInputCarName(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 글자수는 " + 1 + "입니다.");
    }

    @Test
    @DisplayName("차 이름 입력 - 실패(중복된 차 이름)")
    public void inputCarNameValueDuplicate() throws Exception {
        //given
        String inputCarNames = "hi,hi,bye";
        //when - then
        assertThatThrownBy(() -> inputValidator.validateInputCarName(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 차 이름 입니다.");
    }

    @Test
    @DisplayName("차 이름 입력 - 실패(중복된 차 이름)")
    public void inputCarNameIsBlank() throws Exception {
        //given
        String inputCarNames = "hi, ,bye";
        //when - then
        assertThatThrownBy(() -> inputValidator.validateInputCarName(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자로 된 차 이름을 입력해주세요.");
    }
}
