package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.property.ErrorProperty;
import racingcar.validation.InputValidation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class ValidationTest {

    @Test
    void 입력_값_공백_검증_로직_테스트(){
        //given
        String target = "";

        //when
        assertThatThrownBy(()->{
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
        assertThatThrownBy(()->{
                    InputValidation.verifyForSpaceValue(target);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.VALUE_CONTAINS_SPACE);
    }

}
