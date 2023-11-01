package racingcar;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcarFP.Application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 복잡한_예시_1() {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    run("abcd,efgh,ijkl,mnop,qrst,uvwx,zyab,cdef,ghij,klmn", "11");
                    assertThat(output()).contains("abcd : ------", "efgh : -------",
                            "ijkl : ---------", "mnop : --------", "qrst : -----",
                            "uvwx : -----------", "zyab : -------", "cdef : ----------",
                            "ghij : ---------", "klmn : -------", "최종 우승자 : uvwx");
                },
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 3, 4, 4, 4, 4, 4,
                3, 4, 4, 4, 3, 4, 4, 4, 4, 4,
                3, 3, 4, 4, 3, 4, 3, 4, 4, 4,
                3, 3, 4, 3, 3, 4, 3, 4, 4, 3,
                3, 3, 3, 3, 3, 4, 3, 4, 3, 3,
                3, 3, 3, 3, 3, 4, 3, 3, 3, 3
        );
    }

    @Test
    void 복잡한_예시_2() {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    run("opqr,stuv,wxyz,abcd,efgh,ijkl,mnop,qrst,uvwx,zyab", "15");
                    assertThat(output()).contains("opqr : ------------", "stuv : ----------",
                            "wxyz : --------------", "abcd : ----------", "efgh : -----------",
                            "ijkl : ---------", "mnop : --------", "qrst : ------",
                            "uvwx : --------------", "zyab : ----------", "최종 우승자 : wxyz, uvwx");
                },
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 3, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 3, 4, 4,
                4, 3, 4, 4, 4, 3, 3, 3, 4, 4,
                3, 3, 4, 3, 4, 3, 3, 3, 4, 3,
                3, 3, 4, 3, 3, 3, 3, 3, 4, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
