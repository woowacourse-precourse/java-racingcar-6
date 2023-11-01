package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputConsoleTest extends NsTest {

    @Test
    public void 차_이름_입력_테스트() throws Exception {
        run("alpha,bravo,char");
        Assertions.assertThat(output()).contains("alpha", "bravo", "char");
    }

    @Override
    protected void runMain() {
        List<String> carNames = InputConsole.enterCarNames();
        for (String carName : carNames) {
            System.out.println(carName);
        }
    }

}