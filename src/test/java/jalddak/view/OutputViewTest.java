package jalddak.view;

import static racingcar.view.OutputView.printPerMatchResult;
import static racingcar.view.OutputView.printSystemMessage;
import static racingcar.view.SystemMessage.ASK_CAR_LIST;
import static racingcar.view.SystemMessage.ASK_NUM_OF_MATCHES;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    void 출력확인_printSystemMessage() {
        printSystemMessage(ASK_CAR_LIST);
        printSystemMessage(ASK_NUM_OF_MATCHES);
    }

    @Test
    void 출력확인_printAllMatchesResult() {
        List<Map<String, Integer>> givenList = new ArrayList<>();
        Map<String, Integer> start = new LinkedHashMap<>();
        start.put("HJ", 0);
        start.put("HS", 0);
        start.put("SJ", 0);
        Map<String, Integer> second = new LinkedHashMap<>();
        second.put("HJ", 4);
        second.put("HS", 2);
        second.put("SJ", 7);
        givenList.add(start);
        givenList.add(second);
        for (Map<String, Integer> given : givenList) {
            printPerMatchResult(given);
        }
    }
}
