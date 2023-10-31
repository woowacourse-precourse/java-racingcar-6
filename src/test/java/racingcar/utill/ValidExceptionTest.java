package racingcar.utill;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ValidExceptionTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("이름은 5자 이하 검사.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", ""})
    void isValidFIveLessString(String input) {
        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.lessFIveLen(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("한글 포함 검사")
    @ParameterizedTest
    @ValueSource(strings = {"한asd", "한글", "asd한", "한asd글"})
    void isValidIncludeKoreanCheck(String input) {
        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.includeKorean(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자를 포함하는 여부 검사.")
    @ParameterizedTest
    @ValueSource(strings = {"한1", "한1글", "1한", "한12글", "123"})
    void isValidIncludeNum(String input) {
        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.includeNum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백 입력 검사")
    @Test
    void isValidBlankCheck() {
        // given
        String input = "";
        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.blankCheck(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("양수 입력 검사.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-12314"})
    void isValidPositiveCheck(String input) {
        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.negative(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 문자열에 한글, 영어가 포함되어있는가.")
    @ParameterizedTest
    @ValueSource(strings = {"1asdf", "asdf1", "asdf", "한글", "한1", "1한", "한1글", "as1dsf", "asd한글", "a한글b", "한글asdf"})
    void isValidIncludeString(String input) {
        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.includeString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특수문자 포함 검사")
    @ParameterizedTest
    @ValueSource(strings = {"1!@#", "!@#1", "1@!#", "g!@", "!@#a", "!a@!#", "한글!@#", "!@#한글", "!@#sfd한글"})
    void isValidIncludeSpecialString(String input) {
        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.includeSpecialString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력문자에 공백이 포함되어있는가.")
    @ParameterizedTest
    @ValueSource(strings = {" sdf", " ", "sdf ", "sf sf", "sdf sdf sdf"})
    void isValidIncludeBlank(String input) {
        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.includeBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0 입력 확인")
    @Test
    void isValidZeroCheck() {
        // given
        String input = "0";

        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.zeroNum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 이름 , 다음에는 문자가 나와야한다.")
    @Test
    void isValidCommaNextBlankCheck() {
        // given
        String input = "woo,";

        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.commaNextBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 각각의 이름이 5글자 이하인가 확인")
    @ParameterizedTest
    @ValueSource(strings = {"qweqwe,asd,asd", "asd,qweqwe,asd", "asd,asd,qweqwe"})
    void isValidCarEachNameFIveLessStringCheck(String input) {
        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.NameOfEachFIveLessString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름을 입력할때 자동차 하나만 입력하면 안된다.")
    @Test
    void isValidOneNameOfRaceCarCheck() {
        // given
        String input = "woo";

        // then
        Assertions.assertThatThrownBy(
                        () -> ValidException.onlyOneNameOfRaceCar(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}