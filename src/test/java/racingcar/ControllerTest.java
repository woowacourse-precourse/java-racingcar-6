package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.Controller;

public class controllerTest {

    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller();
    }

    @Test
    void strNum_to_intNum() {
        String strNumber = "7";
        int result = controller.getAttemptNumber(strNumber);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void seperateName() {
        String input = "a,b,c,d,eeee,ff";
        List<String> result = controller.seperateNames(input);
        assertThat(result).isEqualTo(Arrays.asList("a", "b", "c", "d", "eeee", "ff"));
    }

    @Test
    void checkRandom() {
        List<Integer> ramdomNums = controller.makeRandomNumberList(4);
        for (int x : ramdomNums) {
            assertEquals((x >= 0 && x <= 9), true);
        }
    }

    @Test
    void changeZeroOne() {
        List<Integer> input = Arrays.asList(4, 5, 6, 1, 2, 3, 7, 8, 9);
        List<Integer> output = controller.replaceZeroAndOne(input);
        assertThat(output).isEqualTo(Arrays.asList(1, 1, 1, 0, 0, 0, 1, 1, 1));

    }

    //play, whoWinner 메소드는 carList가 있어 더 고민 필요
}
