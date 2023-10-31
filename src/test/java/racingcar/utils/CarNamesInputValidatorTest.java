package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.CarNamesInputValidator.CarNamesInputExceptionMessage;

class CarNamesInputValidatorTest {
    @Nested
    @DisplayName("올바른 입력 테스트")
    class CorrectInputTest {

        @ParameterizedTest
        @ValueSource(strings = {"jungi,GamJa,a,bi,tEo,Laqy", "준기,포비,왼손"})
        @DisplayName("[성공 테스트] 1 ~ 5 자리의 문자 입력")
        void basic(String input) {
            Assertions.assertThatCode(() -> CarNamesInputValidator.validate(input))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = " pobi,j n,k   ,J u N")
        @DisplayName("[성공 테스트] 1 ~ 5 자리의 공백 포함 문자 입력")
        void blankMix(String input) {
            Assertions.assertThatCode(() -> CarNamesInputValidator.validate(input))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = "!,@#,$%^,&*(),_+{}:,<>?")
        @DisplayName("[성공 테스트] 1 ~ 5 자리의 특수 문자 입력")
        void specialCharacters(String input) {
            Assertions.assertThatCode(() -> CarNamesInputValidator.validate(input))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = "'\\','\n','\r','\t','\b','\f','\'','\"'")
        @DisplayName("[성공 테스트] 이스케이프 입력")
        void escapeCharacters(String input) {
            Assertions.assertThatCode(() -> CarNamesInputValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("잘못된 입력 테스트")
    class WrongInputTest {
        @ParameterizedTest
        @ValueSource(strings = "jun,junnn,junnng")
        @DisplayName("[실패 테스트] 길이 5를 넘어가는 입력")
        void wrongLengthInputTest(String input) {
            // when, then
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(input))
                    .hasMessage(CarNamesInputExceptionMessage.OUT_OF_LENGTH.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = " ,  ,   ")
        @DisplayName("[실패 테스트] 공백만 존재하는 문자 입력")
        void onlyBlankInputTest1(String input) {
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(input))
                    .hasMessage(CarNamesInputExceptionMessage.CAR_NAME_BLANK.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = "")
        @DisplayName("[실패 테스트] 입력값 없음")
        void test(String input) {
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(input))
                    .hasMessage(CarNamesInputExceptionMessage.BLANK_INPUT.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {",pobi,jun", "pobi,jun,", ",김준비,"})
        @DisplayName("[실패 테스트] 쉼표가 양 끝에 있는 입력")
        void onlyBlankInputTest2(String input) {
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(input))
                    .hasMessage(CarNamesInputExceptionMessage.CAR_NAME_BLANK.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = "pobi,jun,")
        @DisplayName("[실패 테스트] 쉼표가 맨 뒤에 있는 입력")
        void onlyBlankInputTest3(String input) {
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(input))
                    .hasMessage(CarNamesInputExceptionMessage.CAR_NAME_BLANK.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"pobi,,jun", ",,pobi,jun", "pobi,jun,,"})
        @DisplayName("[실패 테스트] 쉼표가 중간에 연속으로 있는 입력은 공백을 의미한다")
        void onlyBlankInputTest4(String input) {
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(input))
                    .hasMessage(CarNamesInputExceptionMessage.CAR_NAME_BLANK.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = "pobi,jun,K!ING,pobi")
        @DisplayName("[실패 테스트] 중복 이름 존재")
        void duplicateTest(String input) {
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(input))
                    .hasMessage(CarNamesInputExceptionMessage.DUPLICATE_EXISTS.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = "pobi,jun,woote, !_!,  WWW,LEO,Lisa,*(!(,pauq,fello,GUCCI")
        @DisplayName("[실패 테스트] 10개 이상인 이름 입력")
        void outOfTotalCountTest(String input) {
            Assertions.assertThatThrownBy(() -> CarNamesInputValidator.validate(input))
                    .hasMessage(CarNamesInputExceptionMessage.OUT_OF_TOTAL_COUNT.getError());
        }
    }

}