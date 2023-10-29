package racingcar.utility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 입력값이_공백인_경우_true_반환() {

        boolean stringNull = Validator.isBlank(null);
        boolean blank = Validator.isBlank(" ");
        boolean empty = Validator.isBlank("");

        assertThat(stringNull).isTrue();
        assertThat(blank).isTrue();
        assertThat(empty).isTrue();

    }

    @Test
    void 전달받은_이름이_5글자_이상인_경우_false_반환() {
        boolean nineLength = Validator.isInNameRange("123456789");
        boolean sixLength = Validator.isInNameRange("123456");

        assertThat(nineLength).isFalse();
        assertThat(sixLength).isFalse();
    }

    @Test
    void 전달받은_이름이_5글자_이하인_경우_true_반환() {
        boolean fiveLength = Validator.isInNameRange("12345");
        boolean oneLength = Validator.isInNameRange("1");
        boolean zeroLength = Validator.isInNameRange("");

        assertThat(fiveLength).isTrue();
        assertThat(oneLength).isTrue();
        assertThat(zeroLength).isTrue();
    }

    @Test
    void 전달받은_이름들_중_중복된_값이_있는_경우_true_반환() {
        List<String> koreanNames = Arrays.asList("가", "나", "가", "다");
        List<String> englishNames = Arrays.asList("pobi", "woni", "jun", "pobi");

        assertThat(Validator.hasSameName(koreanNames)).isTrue();
        assertThat(Validator.hasSameName(englishNames)).isTrue();
    }

    @Test
    void 전달받은_이름들_중_중복된_값이_없는_경우_false_반환() {
        List<String> koreanNames = Arrays.asList("가", "나", "다", "라");
        List<String> englishNames = Arrays.asList("pobi", "woni", "jun", "gugi");

        assertThat(Validator.hasSameName(koreanNames)).isFalse();
        assertThat(Validator.hasSameName(englishNames)).isFalse();
    }

    @Test
    void 중복값_체크_다양한_예시() {
        List<String> notSame = Arrays.asList("가", "", "    ", "가나다", "^%&");
        List<String> same = Arrays.asList("1", "quankei", "!%&(", "1", "0", "0");

        assertThat(Validator.hasSameName(notSame)).isFalse();
        assertThat(Validator.hasSameName(same)).isTrue();

    }

    @Test
    void validateInput_이름으로_공백을_입력한_경우_예외_발생() {
        String blank = "";

        assertThatThrownBy(() -> Validator.validateInput(blank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 입력할 수 없습니다.");
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


}