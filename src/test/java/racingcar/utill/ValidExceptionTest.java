package racingcar.utill;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ValidExceptionTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("이름은 5자 이하 검사.")
    @Test
    void isValidFIveLessString() {

    }

    @DisplayName("한글 포함 검사")
    @Test
    void isValidIncludeKoreanCheck() {
        // given

        // when

        // then
    }

    @DisplayName("숫자를 포함하는 여부 검사.")
    @Test
    void isValidIncludeNum() {
        // given

        // when

        // then
    }

    @DisplayName("공백 입력 검사")
    @Test
    void isValidBlankCheck() {
        // given

        // when

        // then
    }

    @DisplayName("양수 입력 검사.")
    @Test
    void isValidPositiveCheck() {
        // given

        // when

        // then
    }

    @DisplayName("입력된 문자열에 한글, 영어가 포함되어있는가.")
    @Test
    void isValidIncludeString() {
        // given

        // when

        // then
    }

    @DisplayName("특수문자 포함 검사")
    @Test
    void isValidIncludeSpecialString() {
        // given

        // when

        // then
    }

    @DisplayName("입력문자에 공백이 포함되어있는가.")
    @Test
    void isValidIncludeBlank() {
        // given

        // when

        // then
    }

    @DisplayName("0 입력 확인")
    @Test
    void isValidZeroCheck() {
        // given

        // when

        // then
    }

    @DisplayName("문자열 이름 , 다음에는 문자가 나와야한다.")
    @Test
    void isValidCommaNextBlankCheck() {
        // given

        // when

        // then
    }

    @DisplayName("자동차의 각각의 이름이 5글자 이하인가 확인")
    @Test
    void isValidCarEachNameFIveLessStringCheck() {
        // given

        // when

        // then
    }

    @DisplayName("자동차의 이름을 입력할때 자동차 하나만 입력하면 안된다.")
    @Test
    void isValidOneNameOfRaceCarCheck() {
        // given

        // when

        // then
    }
}