package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.utils.Util;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UtilTest {

    String carNames;

    @BeforeEach
    void init() {
        carNames = "supra,  gr86,   GTR";
    }

    @Test
    void 공백을_지운다() {
        String result = Util.trim(carNames);
        String expected = "supra,gr86,GTR";
        assertEquals(expected, result);
    }

    @Test
    void 배열에_이름을_담는다() {
        List<String> actual = Util.toArrayList(carNames);
        List<String> expected = Arrays.asList("supra", "gr86", "GTR");
        assertEquals(expected, actual);
    }

    @Test
    void 중복_요소의_개수를_구한다() {
        List<String> nameList = Arrays.asList("Jason", "Jimmy", "Mustang", "Kentucky", "Jimmy", "Mustang");
        long count = Util.countDuplicate(nameList);
        assertEquals(4L, count);
    }

    @Test
    void 최대값을_구한다() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        ArrayList<Integer> emptyList = new ArrayList<>();

        int result1 = Util.getMaxValue(list1);
        int result2 = Util.getMaxValue(list2);
        int result3 = Util.getMaxValue(emptyList);

        assertEquals(5, result1);
        assertEquals(50, result2);
        assertEquals(-1, result3);
    }
}