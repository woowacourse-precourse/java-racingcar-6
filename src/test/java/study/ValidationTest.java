package study;

import org.junit.jupiter.api.Test;
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
                .hasMessage("[ERROR] 입력값이 공백일 수는 없습니다.");
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
                .hasMessage("[ERROR] 입력값에 공백이 포함되었습니다.");
    }
}
