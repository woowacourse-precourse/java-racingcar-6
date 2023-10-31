package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static model.Constants.STANDARD_NUMBER_OF_ATTEMPTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.CarInformation;
import org.junit.jupiter.api.Test;
import service.IllegalLogic;
import service.RacingCarGameLogic;

public class Ssung2sinTest extends NsTest {
    IllegalLogic illegalLogic=new IllegalLogic();
    CarInformation carInformation=new CarInformation();
    RacingCarGameLogic racingCarGameLogic=new RacingCarGameLogic();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void 여러개의_이름이_들어올_경우_배열에_잘_나눠져_들어오는지(){
        String[] splitCarName= illegalLogic.splitCarName("pobi,woni,java,jigi");
        assertThat(splitCarName).contains("pobi","woni","java","jigi");
    }

    @Test
    void 배열에_있는_이름들을_리스트에_넣기(){
        String[] splitCarName= illegalLogic.splitCarName("pobi,woni,java,jigi");
        List<String> carNames=new ArrayList<>();
        carNames.addAll(Arrays.asList(splitCarName));
        carInformation.setCarNames(carNames);
        assertThat(carInformation.getCarNames()).contains("pobi","woni","java","jigi");
    }
    @Test
    void 하나의_이름만_들어올_경우_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백의_이름이_들어올_경우_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수_입력이_숫자가_아닐때(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 한글_이름이_들어올_경우_재대로_처리되는지(){
        String[] splitCarName= illegalLogic.splitCarName("성신,자바,지기,메르세데스,비엠더블유");
        List<String> carNames=new ArrayList<>();
        carNames.addAll(Arrays.asList(splitCarName));
        carInformation.setCarNames(carNames);
        assertThat(carInformation.getCarNames()).contains("성신","자바","지기","메르세데스","비엠더블유");
    }

    @Test
    void 공동_우승자_출력_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
