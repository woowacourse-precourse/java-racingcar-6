package racingcar.validate.impls;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerDetectorValidatorTest {

    private final WinnerDetectorValidator validator = new WinnerDetectorValidator();

    @Test
    @DisplayName("우승자가 한명도 없을 때")
    void zeroWinnerTest() {
        //given
        Object sample = new ArrayList<String>();
        //then
        assertThatThrownBy(()-> validator.validate(sample))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("우승자가 없습니다.");
     }

     @Test
     @DisplayName("정상적인 우승자 검증시")
     void legalProcessTest() throws Exception{
         //given
         List<String> sample = Arrays.asList("aa", "bb", "cc");
         //when
         validator.validate(sample);
         //then
         assertTrue(true);
      }
}