package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarNamesInputValidatorTest {
    @Nested
    class CorrectInputTest {

        @Test
        @DisplayName("[성공 테스트] 1 ~ 5 자리의 문자 입력")
        void basic() {
            // given
            String input = "jungi,GamJa,a,bi,tEo,Laqy";
            // when, then
            Assertions.assertThatCode(() -> CarNamesInputValidator.validate(input))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("[성공 테스트] 1 ~ 5 자리의 공백 포함 문자 입력")
        void blankMix() {
            // given
            String blankMixInput = " pobi,j n,k   ,J u N";
            // when, then
            Assertions.assertThatCode(() -> CarNamesInputValidator.validate(blankMixInput))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("[성공 테스트] 1 ~ 5 자리의 특수 문자 입력")
        void specialCharacters() {
            // given
            String input = "!,@#,$%^,&*(),_+{}:,<>?";
            // when, then
            Assertions.assertThatCode(() -> CarNamesInputValidator.validate(input))
                    .doesNotThrowAnyException();
        }

        @Test
        void escapeCharacters() {
            // given
            String input = "'\\','\n','\r','\t','\b','\f','\'','\"'";
            // when, then
            Assertions.assertThatCode(() -> CarNamesInputValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    class WrongInputTest {
        @Test
        @DisplayName("[실패 테스트] 길이 5를 넘어가는 입력")
        void wrongLengthInputTest() {
            // given
            String wrongLengthInput = "jun,junnn,junnng";
            // when, then
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(wrongLengthInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("[실패 테스트] 공백만 존재하는 문자 입력")
        void onlyBlankInputTest1() {
            // given
            String blankInput = " ,  ,   ";
            // when, then
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(blankInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("[실패 테스트]")
        void test() {
            // given
            String blankInput = "";
            // when, then
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(blankInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("[실패 테스트] 쉼표가 맨 앞에 있는 입력")
        void onlyBlankInputTest2() {
            // given
            String blankInput = ",pobi,jun";
            // when, then
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(blankInput))
                    .hasMessageContaining("첫 번째 문자로 콤마(,)를 입력하면 안됩니다.");
        }

        @Test
        @DisplayName("[실패 테스트] 쉼표가 맨 뒤에 있는 입력")
        void onlyBlankInputTest3() {
            // given
            String blankInput = "pobi,jun,";
            // when, then
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(blankInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("[실패 테스트] 쉼표가 중간에 연속으로 있는 입력은 공백을 의미한다")
        void onlyBlankInputTest4() {
            // given
            String blankInput = "pobi,,jun";
            // when, then
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(blankInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("[실패 테스트] 쉼표가 맨 앞에 연속으로 있는 입력은 공백을 의미한다")
        void onlyBlankInputTest5() {
            // given
            String blankInput = ",,pobi,jun";
            // when, then
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(blankInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("[실패 테스트] 쉼표가 맨 뒤에 연속으로 있는 입력은 공백을 의미한다")
        void onlyBlankInputTest6() {
            // given
            String blankInput = "pobi,jun,,";
            // when, then
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(blankInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}