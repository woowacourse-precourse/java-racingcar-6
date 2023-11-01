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
        CarInformation carInformation=new CarInformation();
        carInformation.setCarNames(carNames);
        assertThat(carInformation.getCarNames()).contains("pobi","woni","java","jigi");
    }
    @Test
    void 자동차_입력_예외_처리1_하나의_차량만_입력(){ //자동차 경주기때문에 1개만 들어올 경우 예외처리함
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_입력_예외_처리2_공백입력(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수_입력_예외_처리1_숫자가_아닌문자_입력(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수_입력_예외_처리2_공백_입력(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 어떤_문자든_5자리면_입력되는지_확인(){
        String[] splitCarName= illegalLogic.splitCarName("12345,WHERE,hello,메르세데스,비엠더블유");
        List<String> carNames=new ArrayList<>();
        carNames.addAll(Arrays.asList(splitCarName));
        CarInformation carInformation=new CarInformation();
        carInformation.setCarNames(carNames);
        assertThat(carInformation.getCarNames()).contains("12345","WHERE","hello","메르세데스","비엠더블유");
    }

    @Test
    void 공동_우승자_출력_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : -", "woni : "," " ,
                            "pobi : --", "woni : -"," " ,
                            "pobi : --", "woni : --"," " ,
                            "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 둘다_전진하지_않아도_공동_우승자_출력_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
