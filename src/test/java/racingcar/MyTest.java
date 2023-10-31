package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 중복된_이름() {
        List<String> carNameList = new ArrayList<>();
        carNameList.add("pobi");
        carNameList.add("pobi");

        ManageRace manageRace = new ManageRace();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> manageRace.checkValidNames(carNameList))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
