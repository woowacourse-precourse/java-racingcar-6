package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.Input;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.controller.Input.checkDuplicateName;

public class InputTest {

    @Test
    void 중복된_입력() {
        List<String> names = new ArrayList<>();
        names.add("poobee");
        names.add("poobee");
        assertThatThrownBy(() -> checkDuplicateName(names)).isInstanceOf(IllegalArgumentException.class);
    }
}
