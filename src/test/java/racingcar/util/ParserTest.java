package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private final Parser parser = new Parser();

    @DisplayName("입력받은 자동차 이름들을 쉼표를 구분자로 하여 분리하는 기능")
    @Test
    void parseCarNamesTest(){

       //given
       String input = "1,2";

       //when
       String[] result = parser.parseCarNames(input).toArray(new String[0]);

       //then
       assertThat(result).contains("2", "1");
       assertThat(result).containsExactly("1", "2");
   }

    @DisplayName("입력받은 시도 횟수를 String이 아닌 Int 형식으로 반환하는 기능")
    @Test
    void parseTrialNumberTest() {

        //given
        String input = "5";
        int number = 5;

        //when
        int result = parser.parseTrialNumber(input);

        //then
        assertThat(result).isEqualTo(number);

    }
}