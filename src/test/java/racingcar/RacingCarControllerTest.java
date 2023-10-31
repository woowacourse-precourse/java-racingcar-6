package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarControllerTest {
    RacingCarController racingCarController = new RacingCarController();

    @DisplayName("자동차 이름 입력 기능 테스트")
    @Test
    void testInputRacingCarName() {
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> result = racingCarController.inputRacingCarName();

        assertThat(result).contains("pobi", "woni", "jun");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @DisplayName("시도할 횟수 입력 기능 테스트")
    void testInputTotalTurn() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = racingCarController.inputTotalTurn();
        String resultToString = Integer.toString(result);

        assertThat(resultToString).contains("1");
    }
}
