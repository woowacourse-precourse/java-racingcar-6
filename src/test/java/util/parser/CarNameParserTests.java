package util.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.parser.CarNameParser;
import racingcar.util.parser.CarNameParserImpl;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarNameParserTests {
    private final CarNameParser carNameParser = new CarNameParserImpl();

    @Test
    @DisplayName("이름이 없는 경우에도 빈 문자열로 변환된다")
    void test1() {
        // given
        String input = "첫번째,두번째,세번째,,다섯번째";

        // when
        List<String> result = carNameParser.parse(input);

        // then
        String[] expect = {"첫번째", "두번째", "세번째","","다섯번째"};
        for ( int i = 0; i < expect.length; i++ )
            assertThat(result.get(i)).isEqualTo(expect[i]);
    }
}
