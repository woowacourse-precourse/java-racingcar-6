package mytest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.RacingInfo;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayResultTest extends NsTest  {
    final int GO = 4;
    final int STOP = 3;

    @Test
    void getResult_실행결과_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("minji,jiji", "2");
                    assertThat(output()).contains("minji : -", "jiji : ", "minji : --", "jiji : -");
                },
                GO, STOP, GO, GO
        );
    }

    @Test
    void getWinner_승자_찾아_출력(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("minji,jiji,yuji", "2");
                    assertThat(output()).contains("최종 우승자 : minji, jiji");
                },
                GO, GO, STOP, GO, GO, GO
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}