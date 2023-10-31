package racingcar.validate.impls;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validate.Validator;

class RaceGameStateValidatorTest {

    Validator validator;
    @BeforeEach
    void initialize(){
        validator = new RaceGameStateValidator();
    }

    @Test
    @DisplayName("길이와 유일성 등 모든 검증에 대한 성공 케이스")
    void validAllCaseTest() {
        //given
        List<String> samples = Arrays.asList("pobi","woni", "jun");
        //when
        validator.validate(samples);
        //then
        assertTrue(true);
     }


}