package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test void 승자_최대값_확인(){
        //input
        RacingContest racingContest = new RacingContest(3);
        racingContest.insertCar(new RacingCar("player1"));
        racingContest.insertCar(new RacingCar("player2"));

        //play contest
        racingContest.playGame();
        int max = 0;
        List<String> maxList = new ArrayList<>();
        for(RacingCar carInfo : racingContest.racingCars){
            if(max==carInfo.getAdvanceCount()){
                maxList.add(carInfo.getName());
            }

            if(max<carInfo.getAdvanceCount()) {
                max = carInfo.getAdvanceCount();
                maxList.clear();
                maxList.add(carInfo.getName());
            }
        }
        ArrayList<String> winnerList = racingContest.returnWinner();
        assertThat(maxList).containsExactlyElementsOf(winnerList);
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
