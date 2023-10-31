package racingcar.validate.impls;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validate.Validator;

class NumberOfParticipantValidatorTest {

    Validator validator = new NumberOfParticipantValidator();

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