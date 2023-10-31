package validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.property.ErrorProperty;
import racingcar.property.ValidateProperty;
import racingcar.validation.InputValidation;
import racingcar.validation.NameValidation;
import racingcar.validation.CountValidation;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class ValidationTest {

    @Test
    void 입력_값_공백_검증_로직_테스트(){
        //given
        String target = "";

        //when
        assertThatThrownBy(()-> {
            InputValidation.verifyForEmptyValue(target);
        }
            ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.VALUE_IS_EMPTY);
    }

    @Test
    void 입력_값_공백_포함_검증_로직_테스트(){
        //given
        String target = "pobi,woni, jun";
        //when
        assertThatThrownBy(()-> {
                    InputValidation.verifyForSpaceValue(target);
        }
            ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.VALUE_CONTAINS_SPACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pob1","pobi@","포비-"})
    void 이름_입력_값_한글_혹은_영어_검증_로직_테스트(String inputValue){
        assertThatThrownBy(()-> {
            NameValidation.verifyForRacerNameIsEngOrKor(inputValue);
        }
            ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.NAME_VALUE_IS_NOT_CORRECT_FORM);
    }

    @ParameterizedTest
    @ValueSource(strings = {"테스트유저1","testuser2"})
    void 이름_입력_값_길이_초과_검증_로직_테스트(String inputValue){
        //given
        Integer nameStandardLength = ValidateProperty.NAME_LENGTH_STANDARD;

        //when
        assertThatThrownBy(()-> {
            NameValidation.verifyForRacerNameIsLengthNotOver(inputValue);
        }
            ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.NAME_VALUE_LENGTH_IS_OVER);
    }

    @Test
    void 이름_입력_값_중복_검증_로직_테스트(){
        //given
        String racerNameList = "pobi,woni,pobi";

        //when
        assertThatThrownBy(()->{
            NameValidation.verifyForRacerNameIsDuplicate(racerNameList);
        }
            ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.NAME_VALUE_IS_DUPLICATE);
    }

    @Test
    void 시도_횟수_입력_값_숫자_검증_로직_테스트(){
        //given
        String target="test";

        //when
        assertThatThrownBy(()->{
            CountValidation.verifyForRaceCountIsNumericValue(target);
        }
            ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.SCORE_VALUE_IS_NOT_NUMERIC);
    }

    @Test
    void 시도_횟수_입력_값_Integer_범위벗어나는지_검증_로직_테스트(){
        //given
        String maxValue=String.valueOf(Integer.MAX_VALUE);
        BigInteger b=new BigInteger(maxValue).add(BigInteger.ONE);
        String target = b.toString();

        //when
        assertThatThrownBy(()->{
                    CountValidation.verifyForRaceCountIsOverStandard(target);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.SCORE_VALUE_IS_OVER_STANDARD);
    }

    @Test
    void 이름_입력_값_마지막자리_콤마_검증_로직(){
        //given
        String target = "test,user,";

        //when
        assertThatThrownBy(()->{
            NameValidation.verifyForRacerNameContainComma(target);
        }
            ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.NAME_VALUE_CONTAINS_COMMA);
    }
}
