package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @Test
    void 이름_길이초과() {
        String inputLists = "seungho,woni,jun";
        System.setIn(new ByteArrayInputStream(inputLists.getBytes()));
        Assertions.assertThatThrownBy(Application::askRacingCars)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_숫자입력() {
        //given
        String trial = "I";
        System.setIn(new ByteArrayInputStream(trial.getBytes()));

        //then
        Assertions.assertThatThrownBy(Application::askTrial)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
