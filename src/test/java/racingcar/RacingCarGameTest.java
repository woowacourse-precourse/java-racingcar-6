package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
//    @Test
//    void 여러_이름으로_Car_만들기(){
//        RacingCarGame mock = mock(RacingCarGame.class);
//        String[] split = {"cys1", "cys2", "cys3"};
//        when(mock.splitInputNames()).thenReturn(split);
//        mock.inputNames(mock.splitInputNames());
//
//        assertThat(mock.carsToString(mock.cars)).contains("cys1", "cys2", "cys3");
//    }

    @Test
    void 게임_3명_5회() {
        assertRandomNumberInRangeTest(
                ()->{
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ","jun : -"
                            ,"pobi : --","woni : -","jun : --"
                            ,"pobi : ---","woni : --","jun : ---"
                            ,"pobi : ----","woni : ---","jun : ----"
                            ,"pobi : -----","woni : ----","jun : -----"
                            ,"최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
                ,MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
                ,MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
                ,MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
                ,MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
