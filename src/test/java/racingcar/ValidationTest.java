package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    void 이름에_대한_예외_처리() {
        ArrayList<String> input1 = new ArrayList<>(Arrays.asList("abc", "def", "", "", ""));
        ArrayList<String> input2 = new ArrayList<>(Arrays.asList("abc", "def", "dfsegd"));
        ArrayList<String> input3 = new ArrayList<>(Arrays.asList("  ", "def", "dfseg"));
        ArrayList<String> input4 = new ArrayList<>(Arrays.asList("def", "def", "dfseg"));


        assertSimpleTest(() ->
                assertThrows(IllegalArgumentException.class, () -> Validation.validateCarNames(input1))
        );
        assertSimpleTest(() ->
                assertThrows(IllegalArgumentException.class, () -> Validation.validateCarNames(input2))
        );
        assertSimpleTest(() ->
                assertThrows(IllegalArgumentException.class, () -> Validation.validateCarNames(input3))
        );
        assertSimpleTest(() ->
                assertThrows(IllegalArgumentException.class, () -> Validation.validateCarNames(input4))
        );
    }
    @Test
    void 횟수에_대한_예외_처리() {
        String input1 = "-4";
        String input2 = "0";
        String input3 = "abc";
        String input4 = "";

        assertSimpleTest(() ->
                assertThrows(IllegalArgumentException.class, () -> Validation.validateTrytime(input1))
        );
        assertSimpleTest(() ->
                assertThrows(IllegalArgumentException.class, () -> Validation.validateTrytime(input2))
        );
        assertSimpleTest(() ->
                assertThrows(IllegalArgumentException.class, () -> Validation.validateTrytime(input3))
        );
        assertSimpleTest(() ->
                assertThrows(IllegalArgumentException.class, () -> Validation.validateTrytime(input4))
        );

    }
}

