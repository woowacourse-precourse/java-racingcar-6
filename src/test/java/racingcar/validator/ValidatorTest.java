package racingcar.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest extends NsTest {

    @Test
    void 자동차_컴마로_구분_테스트1() {
        String carNames = "pobi,gabi,가나다,123,car1,1자동차";
        Validator validator = new Validator();
        assertThatCode(() -> validator.checkCarNameInputForm(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_컴마로_구분_테스트2() {
        String carNames = "pobi";
        Validator validator = new Validator();
        assertThatCode(() -> validator.checkCarNameInputForm(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_컴마로_구분_예외_테스트1() {
        String carNames = "pobi,gabi/가나다,123,car1,1자동차";
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.checkCarNameInputForm(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("입력 구분을 ,로 하지 않았습니다.");
    }

    @Test
    void 자동차_컴마로_구분_예외_테스트2() {
        String carNames = "pobi/gabi";
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.checkCarNameInputForm(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("입력 구분을 ,로 하지 않았습니다.");
    }


    @Test
    void 자동차_입력_길이_테스트1() {
        Car car = new Car("robinh");
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.checkCarNameForm(car.getName()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("자동차 이름으 길이는 5이하 입니다.");
    }

    @Test
    void 자동차_입력_길이_테스트2() {
        Car car = new Car("robin");
        Validator validator = new Validator();

        assertThatCode(() -> validator.checkCarNameForm(car.getName()))
                .doesNotThrowAnyException();
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
