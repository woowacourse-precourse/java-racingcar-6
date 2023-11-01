package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ResultTest extends NsTest {

    @Test
    void 결과_형식_테스트() {
        Result result = new Result(new Cars("pobi,woni,jun"));
        result.printRaceResult(Arrays.asList("Move", "Stop", "Move"));
        assertThat(output()).contains("pobi : -", "woni : ", "jun : -");
    }

    @Override
    protected void runMain() {

    }
}
