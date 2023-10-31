package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.util.CarNameValidator;
import racingcar.util.RotatingCountValidator;
import racingcar.view.RotatingCount;

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
    void 전진_정지2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP+1
        );
    }

    @Test
    void 차이름_길이_6이상_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_오류_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi_javaji,qwe", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_길이_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javajis"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_이름_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_아무것도_입력없을때_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_숫자섞일때_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pob2i"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차이름_검증_성공_테스트() {
        //given
        CarNameValidator carNameValidator = new CarNameValidator();
        String carNmae = "yuiop,qwer,asd,zc,p,Tksa,AAAAA";

        //when
        boolean check = carNameValidator.check(carNmae);

        //then
        assertThat(check).isEqualTo(true);
    }

    @Test
    void 시도_횟수_검증_성공_테스트() {
        //given
        RotatingCountValidator rotatingCountValidator = new RotatingCountValidator();
        String carNmae = "4";

        //when
        boolean check = rotatingCountValidator.check(carNmae);

        //then
        assertThat(check).isEqualTo(true);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
