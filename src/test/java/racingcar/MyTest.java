package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void 자동차_이름_문자열_List로_변환() {
        String input = "pobi,woni";
        List<String> result = new ArrayList<>();
        result.add("pobi");
        result.add("woni");

        ManageRace manageRace = new ManageRace();
        assertThat(result).isEqualTo(manageRace.stringToList(input));
    }
}
