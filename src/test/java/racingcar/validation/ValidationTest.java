package racingcar.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    void 자동차_이름_입력시_문자열의_길이가_5개_초과하는것이_존재할_경우() {
        String input[] = {"123456", "12345"};

        assertThatThrownBy(() -> validation.lengthCheck(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("문자 열의 크기가 5를 초과 합니다.");
    }

    @Test
    void 자동차_이름_입력시_중복되는_문자가_존재할_경우() {
        String input[] = {"1234", "1234"};

        assertThatThrownBy(() -> validation.duplicateCheck(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력한 이름 중에 중복된 값이 존재 합니다.");
    }

    @Test
    void 자동차_이름_입력시_콤마_사이에_공백_존재할_경우() {
        String input = "1,2,3,,4";

        String splitInput[] = input.split(",");

        assertThatThrownBy(() -> validation.commasBlankCheck(input, splitInput)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력한 문자열 중에 공백이 존재 합니다.");
    }

    @Test
    void 자동차_이름_입력시_콤마가_연속해서_사용되었을때() {
        String input = "1,,";
        String splitInput [] = input.split(",");

        assertThatThrownBy(() -> validation.commasBlankCheck(input, splitInput)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력한 문자열 중에 연속 해서 ','가 입력 되었습니다."); // 연속해서 콤마 사용
    }

    @Test
    void 자동차_입력시_아무것도_입력되지_않았을때(){
        String input = "";
        String splitInput [] = input.split(",");

        assertThatThrownBy(() -> validation.blankCheck(splitInput)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("아무것도 입력 되지 않았습니다."); // 아무 것도 입력하지 않았을 경우
    }
    @Test
    void 실행_횟수_입력시_숫자가_아닌_문자를_입력하였을_경우() {
        String input = "a";

        assertThatThrownBy(() -> validation.chanceCheck(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자를 올 바르게 입력 하세요.");
    }
}