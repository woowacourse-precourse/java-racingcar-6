package racingcar.UtilTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Util.Parser;

public class ParserTest {

    @Test
    @DisplayName("문자열 쉼표기준으로 자르는 기능 테스트")
    public void parseTest() {
        String input = "tico,damas,ray";
        String[] splitedInput = {"tico","damas","ray"};

        assertThat(Parser.parseString(input)).isEqualTo(splitedInput);
    }

}
