package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.GameUtil;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 자동차_이름_입력_후_ArrayList초기화_확인(){
        String carName = "pobi,woni";

        ArrayList<Car> carArrayList = new GameUtil().splitNameArrayList(carName);

        assertThat(carArrayList.get(0).getName()).isEqualTo("pobi");
        assertThat(carArrayList.get(0).getLocation()).isEqualTo(0);
        assertThat(carArrayList.get(1).getName()).isEqualTo("woni");
        assertThat(carArrayList.get(1).getLocation()).isEqualTo(0);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력시_아무것도_입력하지_않을_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1", "pobi,woni", "", "", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력시_중복될_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,pobi", "3", "nsj,ns,sj,nsj", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void split_메소드_사용시_이름이_비어있을_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("nsj, ","3", "nsj,   ,asd","4", "nsj,","2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 회수_입력시_숫자가_아닌_값_입력시_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("nsj,nam,sjn", "1a", "nsj,nam", "*", "nsj,nam", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
