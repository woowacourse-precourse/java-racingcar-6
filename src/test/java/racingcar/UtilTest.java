package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    private static final Util util = new Util();

    @Test
    void 랜덤_숫자_범위_확인() {
        int num = util.getRandomNum();
        assertThat(num).isBetween(0, 9);
    }

    @Test
    void 문자열_자르기() {
        String str = "pobi,woni,jun";

        String[] result = util.splitString(str);

        assertThat(result.length).isEqualTo(3);
        assertThat(Arrays.toString(result)).contains("pobi", "woni", "jun");
    }

    @Test
    void 문자열_반복하기() {
        String str = "pobi";

        String result = util.repeat(str, 3);

        assertThat(result).isEqualTo("pobipobipobi");
    }

    @Test
    void 문자열_합치기() {
        List<String> arr = new ArrayList<>();
        arr.add("pobi");
        arr.add("woni");

        String result = util.join(arr);

        assertThat(result).isEqualTo("pobi, woni");
    }
}
