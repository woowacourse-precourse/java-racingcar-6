package racingcar.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ControllerTest {
    Map<String, Integer> expectedResult = new HashMap<>();
    HashMap<String, Integer> acutalResult;
    Controller controller = new Controller();
    String input;

    @DisplayName("점수판_해쉬맵_생성")
    @Test
    void createScoreBoard_normal() {
        expectedResult.put("jun", 0);
        expectedResult.put("woo", 0);

        input = "jun,woo";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        acutalResult = controller.createScoreBoard();

        assertEquals(expectedResult, acutalResult);
    }
}