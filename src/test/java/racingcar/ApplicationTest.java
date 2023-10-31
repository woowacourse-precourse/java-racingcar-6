package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.validate.InvalidInputException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    InvalidInputException invalidInputException = new InvalidInputException();

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

    @Test
    void 자동차_이름_null_예외_처리() {
        String inputName = null;
        assertThatThrownBy(() -> {
            invalidInputException.checkCarNames(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null입니다.");
    }

    @Test
    void 자동차_이름_공백_예외_처리() {
        String inputName = ",pobi";
        assertThatThrownBy(() -> {
            invalidInputException.checkCarNames(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최소 한 글자 이상이어야 합니다.");
    }

    @Test
    void 자동차_이름_1개_예외_처리() {
        String inputName = "pobi,";
        assertThatThrownBy(() -> {
            invalidInputException.checkCarNames(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차가 2대 이상 있어야만 경주가 가능합니다.");
    }

    @Test
    void 자동차_이름_중복_예외_처리() {
        String inputName = "pobi,pobi";
        assertThatThrownBy(() -> {
            invalidInputException.checkCarNames(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("동일한 자동차 이름을 여러번 입력할 수 없습니다.");
    }

    @Test
    void 이동_시도_횟수_숫자가_아닌_예외_처리() {
        String inputTimes = "abc";
        assertThatThrownBy(() -> {
            invalidInputException.checkTimes(inputTimes);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 시도 횟수는 숫자여야 합니다.");
    }

    @Test
    void 이동_시도_횟수_1미만_예외_처리() {
        String inputTimes = "0";
        assertThatThrownBy(() -> {
            invalidInputException.checkTimes(inputTimes);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 시도 횟수는 1이상이어야 합니다.");
    }

    @Test
    void 자동차_객체_생성_테스트() {
        Car car = new Car("차1");
        assertThat(car).isNotNull();
    }

    @Test
    void 자동차_포지션_업데이트() {
        Car car = new Car("차1");
        car.goOrStayForwardCount(4);
        assertThat(car.goOrStayForwardCount(3)).isEqualTo(1);
    }

    @Test
    void 자동차_포지션_라운드_결과_출력() {
        Car car1 = new Car("차1");
        Car car2 = new Car("차2");
        car1.goOrStayForwardCount(4);
        car2.goOrStayForwardCount(3);
        assertThat(car1.getCurrentPosition()).isEqualTo("차1 : -");
        assertThat(car2.getCurrentPosition()).isEqualTo("차2 : ");
    }

    @Test
    void 자동차_최종_우승자_출력() {
        Car car1 = new Car("차1");
        Car car2 = new Car("차2");
        car1.goOrStayForwardCount(4);
        car2.goOrStayForwardCount(3);
        assertThat(car1.getCarNameAtMaxPosition(1)).isEqualTo("차1");
        assertThat(car2.getCarNameAtMaxPosition(1)).isEqualTo("");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
