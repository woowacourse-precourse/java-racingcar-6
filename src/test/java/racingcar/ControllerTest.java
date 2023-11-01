package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;


public class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller();
    }

    @Test
    void 참가자_이름_입력(){
        String input = "abc,def,,,";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        ArrayList<String> result = controller.getCarsNameInput();

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("abc", "def", "", "", ""));
        assertIterableEquals(expected, result);

        System.setIn(System.in);
    }
}
