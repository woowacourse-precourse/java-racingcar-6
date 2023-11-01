package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @Test
    void 구분자가_포함되지_않은_경우_테스트() {
        final String input = "mist";
        Input testInput = new Input();
        ArrayList<String> result = testInput.getNameList(input);

        assertThat(result).contains("mist");
    }

    @Test
    void 구분자가_포함된_경우_테스트() {
        final String input = "mist,fume";
        Input testInput = new Input();
        ArrayList<String> result = testInput.getNameList(input);

        assertThat(result).contains("fume", "mist");
        assertThat(result).containsExactly("mist", "fume");
    }
}
