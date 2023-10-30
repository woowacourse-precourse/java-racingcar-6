package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest extends NsTest {

    @Test
    void 최대값_가져오기() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(3);
        test.add(5);

        int result = Utils.getMax(test);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 문자열_배열_저장() {
        String str = "pobi,woni,jun";
        ArrayList<String> names = Utils.toArrayList(str);

        assertThat(names).contains("woni", "pobi");
        assertThat(names).containsExactly("pobi", "woni", "jun");

    }


    @Override
    protected void runMain() {

    }
}
