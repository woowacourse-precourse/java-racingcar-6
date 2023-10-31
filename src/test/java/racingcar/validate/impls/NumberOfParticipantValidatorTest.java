package racingcar.validate.impls;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validate.Validator;

class NumberOfParticipantValidatorTest {

    Validator validator = new NumberOfParticipantValidator();
    @Test
    @DisplayName("콘솔로 음수가 입력되었을때")
    void negativePlayerTest() throws Exception{
        //given
        String sample = "-1";
        //then
        Assertions.assertThatThrownBy(() -> validator.validate(sample))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 정수만 입력해주세요.");
     }

     @Test
     @DisplayName("정상적인 검증 시")
     void legalProcessTest() throws Exception{
         //given
         String sample = "1";
         //when
         validator.validate(sample);
         //then
         assertTrue(true);

      }
}