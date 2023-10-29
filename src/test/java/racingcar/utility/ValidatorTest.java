package racingcar.utility;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @Test
    void isBlank_입력값이_공백인_경우_true_반환() {

        boolean stringNull = Validator.isBlank(null);
        boolean blank = Validator.isBlank(" ");
        boolean empty = Validator.isBlank("");
        boolean normal = Validator.isBlank("가나 다라");

        assertThat(stringNull).isTrue();
        assertThat(blank).isTrue();
        assertThat(empty).isTrue();
        assertThat(normal).isFalse();

    }

    @Test
    void isInNameRange_전달받은_이름이_5글자_이상인_경우_false_반환() {
        boolean nineLength = Validator.isInNameRange("123456789");
        boolean sixLength = Validator.isInNameRange("123456");

        assertThat(nineLength).isFalse();
        assertThat(sixLength).isFalse();
    }

    @Test
    void isInNameRange_전달받은_이름이_5글자_이하인_경우_true_반환() {
        boolean fiveLength = Validator.isInNameRange("12345");
        boolean oneLength = Validator.isInNameRange("1");
        boolean zeroLength = Validator.isInNameRange("");

        assertThat(fiveLength).isTrue();
        assertThat(oneLength).isTrue();
        assertThat(zeroLength).isTrue();
    }

    @Test
    void hasSameName_전달받은_이름들_중_중복된_값이_있는_경우_true_반환() {
        List<String> koreanNames = Arrays.asList("가", "나", "가", "다");
        List<String> englishNames = Arrays.asList("pobi", "woni", "jun", "pobi");

        assertThat(Validator.hasSameName(koreanNames)).isTrue();
        assertThat(Validator.hasSameName(englishNames)).isTrue();
    }

    @Test
    void hasSameName_전달받은_이름들_중_중복된_값이_없는_경우_false_반환() {
        List<String> koreanNames = Arrays.asList("가", "나", "다", "라");
        List<String> englishNames = Arrays.asList("pobi", "woni", "jun", "gugi");

        assertThat(Validator.hasSameName(koreanNames)).isFalse();
        assertThat(Validator.hasSameName(englishNames)).isFalse();
    }

    @Test
    void hasSameName_중복값_체크_다양한_예시() {
        List<String> notSame = Arrays.asList("가", "", "    ", "가나다", "^%&");
        List<String> same = Arrays.asList("1", "quankei", "!%&(", "1", "0", "0");

        assertThat(Validator.hasSameName(notSame)).isFalse();
        assertThat(Validator.hasSameName(same)).isTrue();
    }

    @Test
    void isNumber_숫자를_입력한_경우_true_반환() {
        String number = "0123456789";

        assertThat(Validator.isNumber(number)).isTrue();
    }

    @Test
    void isNumber_숫자가_아닌_값을_입력한_경우_false_반환() {
        String number = "1evc52";

        assertThat(Validator.isNumber(number)).isFalse();
    }

    @Test
    void validateInput_이름으로_공백을_입력한_경우_예외_발생() {
        String blank = "";

        assertThatThrownBy(() -> Validator.validateInput(blank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 입력할 수 없습니다.");
    }

    @Test
    void isZero_0을_입력한_경우_true_반환() {
        String zero = "0";

        assertThat(Validator.isZero(zero)).isTrue();
    }

    @Test
    void isZero_0이_아닌_값을_입력한_경우_false_반환() {
        String notZero = "01234";

        assertThat(Validator.isZero(notZero)).isFalse();
    }

    @Test
    void isNumberWithinNineDigits_9자릿수_이하로_입력한_경우_true_반환() {
        String eightDigits = "12345678";

        assertThat(Validator.isNumberWithinNineDigits(eightDigits)).isTrue();
    }

    @Test
    void isNumberWithinNineDigits_9자릿수_초과로_입력한_경우_false_반환() {
        String tenDigits = "1234567890";
        String elevenDigits = "123456789000";

        assertThat(Validator.isNumberWithinNineDigits(tenDigits)).isFalse();
        assertThat(Validator.isNumberWithinNineDigits(elevenDigits)).isFalse();
    }

    @Test
    void validateNameList_이름으로_중복된_값을_입력한_경우_예외_발생() {
        List<String> dupliList = Arrays.asList("pobi", "pobi");

        assertThatThrownBy(() -> Validator.validateNameList(dupliList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름을 사용할 수 없습니다.");
    }

    @Test
    void validateNameList_이름이_5자_초과인_경우_예외_발생() {
        List<String> excessList = Arrays.asList("12345", "123456", "1234");

        assertThatThrownBy(() -> Validator.validateNameList(excessList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하로 입력해주세요.");
    }

    @Test
    void validateGameCount_숫자가_아닌_값을_입력한_경우_예외_발생() {
        String input = "1f2b556cf2";

        assertThatThrownBy(() -> Validator.validateGameCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해주세요.");
    }

    @Test
    void validateGameCount_0을_입력한_경우_예외_발생() {
        String input = "0000000";

        assertThatThrownBy(() -> Validator.validateGameCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 값을 입력해주세요.");
    }

    @Test
    void validateGameCount_9자릿수_초과로_입력한_경우_예외_발생() {
        String input = "1234567890";

        assertThatThrownBy(() -> Validator.validateGameCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("9자릿수까지 입력 가능합니다.");
    }


}