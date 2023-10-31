package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void 차_이름_콤마로_분리_테스트() {
        List<String> splitList = Arrays.asList("pobi", "woni", "jun");

        assertEquals(splitList, StringUtils.toCarNameList("pobi,woni,jun"));
    }

}
