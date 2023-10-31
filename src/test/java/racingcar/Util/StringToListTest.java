package racingcar.Util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class StringToListTest {
    @Test
    public void testAnalysisCarNames_자동차_이름_분석() {
        StringToList stringToList = new StringToList();
        String carNameInput = "pobi,woni,jun";

        List<String> result = stringToList.analysisCarNames(carNameInput);

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    public void testAnalysisTryCountNumber_시도_횟수_분석() {
        StringToList stringToList = new StringToList();
        String tryCountNumInput = "5";

        int result = stringToList.analysisTryCountNumber(tryCountNumInput);

        assertThat(result).isEqualTo(5);
    }
}
