package racingcar.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

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
                .hasMessageContainingAll("자동차 이름은 길이는 5이하 입니다.");
    }

    @Test
    void 자동차_입력_길이_테스트2() {
        Car car = new Car("robin");
        Validator validator = new Validator();

        assertThatCode(() -> validator.checkCarNameForm(car.getName()))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름_중복_테스트() {
        Car car1 = new Car("robih");
        Car car2 = new Car("robih");
        List<String> carNames = new ArrayList<>(List.of(car1.getName(), car2.getName()));

        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.checkDuplicateCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("차 이름이 중복됐습니다.");
    }

    @Test
    void 자동차_개수_테스트() {
        Car car1 = new Car("robih");
        Car car2 = new Car("robin");
        List<String> carNames = new ArrayList<>(List.of(car1.getName(), car2.getName()));

        Validator validator = new Validator();
        assertThatCode(() -> validator.checkCarNum(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_개수_예외_테스트() {
        Car car1 = new Car("robih");
        List<String> carNames = new ArrayList<>(List.of(car1.getName()));

        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.checkCarNum(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("차는 2대 이상 이여야 경주가 가능합니다.");
    }

    @Test
    void 시도_횟수_정수_확인_예외_테스트() {
        String tryNum = "tryNum";
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.checkTryNumType(tryNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("시도 횟수에 대한 입력이 정수가 아닙니다.");
    }

  

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
