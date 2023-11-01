package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import model.CarInformation;
import org.junit.jupiter.api.Test;
import service.IllegalLogic;
import service.RacingCarGameLogic;

public class RacingCarGameLogicTest extends NsTest {
    IllegalLogic illegalLogic=new IllegalLogic();
    RacingCarGameLogic racingCarGameLogic=new RacingCarGameLogic();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 입력한_차량수만큼_카운트_0으로_초기화_되어있는지(){
        CarInformation carInformation=new CarInformation();

    }
    @Test
    void 숫자_4이상_입력시_카운트_증가(){
        CarInformation carInformation=new CarInformation();
        List<Integer> carForwardCount=new ArrayList<>();
        carForwardCount.add(0);
        carInformation.setCarForwardCount(carForwardCount);
        racingCarGameLogic.compareToFrontCount(Randoms.pickNumberInRange(4,9),0);
        assertThat(carInformation.getCarForwardCount().get(0)).isEqualTo(1);
    }
    @Test
    void 숫자_3이하_입력시_카운터_그대로_유지(){
        CarInformation carInformation=new CarInformation();
        List<Integer>carForwardCount=new ArrayList<>();
        carForwardCount.add(3);
        carInformation.setCarForwardCount(carForwardCount);
        racingCarGameLogic.compareToFrontCount(Randoms.pickNumberInRange(0,3),0);
        assertThat(carInformation.getCarForwardCount().get(0)).isEqualTo(3);
    }
    @Test
    void 카운트_수만큼_대시_변환(){
        CarInformation carInformation=new CarInformation();
        List<Integer> carForwardCount=new ArrayList<>();
        carForwardCount.add(3); //count=3
        carInformation.setCarForwardCount(carForwardCount);
        int count=carInformation.getCarForwardCount().get(0);
        String dash=racingCarGameLogic.convertCountToDash(count);
        assertThat(dash).contains("---");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
