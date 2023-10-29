package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {

    @Test
    void validNames_메소드에_전달된_값이_영어_이름과_쉼표로만_이루어졌는지_확인() {
        assertThat(Validation.validNames("apple,pear,melon")).as("정상적인 문자열에 대한 반환값").isEqualTo(true);
        //빈 이름에 대한 예외는 validLength 메소드에서 처리
        assertThat(Validation.validNames("apple,,melon")).as("빈 이름이 포함된 문자열에 대한 반환값").isEqualTo(true);
        assertThat(Validation.validNames("사과,pear,melon")).as("한글이 포함된 문자열에 대한 반환값").isEqualTo(false);
        assertThat(Validation.validNames("apple!,pear,melon")).as("특수기호가 포함된 문자열에 대한 반환값").isEqualTo(false);
        assertThat(Validation.validNames("apple, pear, melon")).as("공백이 포함된 문자열에 대한 반환값").isEqualTo(false);
    }

    @Test
    void validLength_메소드에_전달된_이름들이_5글자_이하인지_확인() {
        List<String> nameList = new ArrayList<>();

        nameList.add("apple");
        nameList.add("pear");
        assertThat(Validation.validLength(nameList)).as("정상적인 이름에 대한 반환값").isEqualTo(true);

        nameList.add("");
        assertThat(Validation.validLength(nameList)).as("빈 이름에 대한 반환값").isEqualTo(false);
        nameList.remove("");

        nameList.add("watermelon");
        assertThat(Validation.validLength(nameList)).as("5글자 초과인 이름에 대한 반환값").isEqualTo(false);
    }

    @Test
    void validNumber_메소드에_전달된_값이_올바른_숫자인지_확인() {
        assertThat(Validation.validNumber("1")).as("숫자에 대한 반환값").isEqualTo(true);
        assertThat(Validation.validNumber("123")).as("큰 숫자에 대한 반환값").isEqualTo(true);

        assertThat(Validation.validNumber("abc")).as("문자에 대한 반환값").isEqualTo(false);
        assertThat(Validation.validNumber("1a")).as("숫자와 문자 조합에 대한 반환값").isEqualTo(false);
        assertThat(Validation.validNumber("1 2")).as("공백이 포함된 숫자에 대한 반환값").isEqualTo(false);
        assertThat(Validation.validNumber("!1")).as("특수기호가 포함된 숫자에 대한 반환값").isEqualTo(false);
        assertThat(Validation.validNumber("001")).as("0이 포함된 입력에 대한 반환값").isEqualTo(true);
        assertThat(Validation.validNumber("0")).as("0회 입력에 대한 반환값").isEqualTo(false);
    }
}