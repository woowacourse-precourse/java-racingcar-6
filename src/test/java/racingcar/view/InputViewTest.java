package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import racingcar.dto.input.InputDTO;

public class InputViewTest extends NsTest {

    @Override
    protected void runMain() {
        InputDTO inputDTO = InputView.readUserInput();

        // 테스트 확인
        assertEquals("hyunjin,pobi,lefthand", String.join(",", inputDTO.getNames().getNameList()));
        assertEquals(3, inputDTO.getTrialCount().getCount());

    }

    @Test
    public void readUserInput_테스트() {
        run("hyunjin,pobi,lefthand", "3");
    }
}
