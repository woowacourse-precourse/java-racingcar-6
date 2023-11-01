package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarNameParserTest {

    @Test
    public void 쉼표로_구분한다() {
        List<String> carNameList = CarNameParser.splitAndStrip("pobi,woni,jun");
        assertThat(carNameList).contains("pobi", "woni", "jun");
    }

    @Test
    public void 앞_뒤_공백을_제거한다() {
        List<String> carNameList = CarNameParser.splitAndStrip("pobi , woni, jun ");
        assertThat(carNameList).contains("pobi", "woni", "jun");
    }
}
