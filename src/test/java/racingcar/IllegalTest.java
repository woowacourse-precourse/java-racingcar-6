package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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

public class IllegalTest extends NsTest {
    IllegalLogic illegalLogic=new IllegalLogic();
    RacingCarGameLogic racingCarGameLogic=new RacingCarGameLogic();
    @Test
    void 여러개의_이름이_들어올_경우_Model안의_CarInformation에_저장되는지_확인(){
        CarInformation carInformation=new CarInformation();
        illegalLogic.processingIllegalLogicOfCarNames("pobi,woni,java,jigi");
        assertThat(carInformation.getCarNames()).contains("pobi","woni","java","jigi");
    }

    @Test
    void 차_생성시_차_갯수만큼_카운트_0으로_초기화(){
        CarInformation carInformation=new CarInformation();
        String[] carNames={"pobi","woni","java","jigi"};
        racingCarGameLogic.insertCarName(carNames);
        assertThat(carInformation.getCarForwardCount()).contains(0,0,0,0);
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
        CarInformation  carInformation=new CarInformation();
        illegalLogic.processingIllegalLogicOfCarNames("12345,WHERE,hello,메르세데스,비엠더블유"); //생성하고 예외사항 비교후 model에 입력
        assertThat(carInformation.getCarNames()).contains("12345","WHERE","hello","메르세데스","비엠더블유");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
