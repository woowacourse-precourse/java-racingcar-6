package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputConsoleTest extends NsTest {

    @Test
    public void 차_이름과_라운드_입력_테스트() throws Exception {
        run("alpha,bravo,char", "5");
        Assertions.assertThat(output()).contains("alpha", "bravo", "char", "5");
    }

    @Override
    protected void runMain() {
        List<String> carNames = InputConsole.enterCarNames();
        for (String carName : carNames) {
            System.out.println(carName);
        }

        int round = InputConsole.enterRound();
        System.out.println(round);
    }

}