package racingcar.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest extends NsTest {
    private static Validator validator;
    @BeforeAll
    static void setUp(){
        validator = new Validator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,gabi,가나다,123,car1,1자동차", "pobi"})
    void 자동차_컴마로_구분_테스트(String carNames) {
        assertThatCode(() -> validator.checkCarNameInputForm(carNames))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,gabi/가나다,123,car1,1자동차", "pobi/gabi"})
    void 자동차_컴마로_구분_예외_테스트(String carNames) {
        assertThatThrownBy(() -> validator.checkCarNameInputForm(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("입력 구분을 ,로 하지 않았습니다.");
    }

    @Test
    void 자동차_입력_길이_테스트() {
        Car car = new Car("robin");

        assertThatCode(() -> validator.checkCarNameForm(car.getName()))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_입력_길이_예외_테스트() {
        Car car = new Car("robinh");

        assertThatThrownBy(() -> validator.checkCarNameForm(car.getName()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("자동차 이름은 길이는 5이하 입니다.");
    }

    @Test
    void 자동차_이름_중복_테스트() {
        Car car1 = new Car("robih");
        Car car2 = new Car("robih");
        List<String> carNames = new ArrayList<>(List.of(car1.getName(), car2.getName()));

        assertThatThrownBy(() -> validator.checkDuplicateCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("차 이름이 중복됐습니다.");
    }

    @Test
    void 자동차_개수_테스트() {
        Car car1 = new Car("robih");
        Car car2 = new Car("robin");
        List<String> carNames = new ArrayList<>(List.of(car1.getName(), car2.getName()));

        assertThatCode(() -> validator.checkCarNum(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_개수_예외_테스트() {
        Car car1 = new Car("robih");
        List<String> carNames = new ArrayList<>(List.of(car1.getName()));

        assertThatThrownBy(() -> validator.checkCarNum(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("차는 2대 이상 이여야 경주가 가능합니다.");
    }

    @Test
    void 시도_횟수_정수_확인_예외_테스트() {
        String tryNum = "tryNum";

        assertThatThrownBy(() -> validator.checkTryNumType(tryNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("시도 횟수에 대한 입력이 정수가 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-12, 0})
    void 시도_횟수_양수_확인_예외_테스트1(int tryNum) {
        assertThatThrownBy(() -> validator.checkTryNum(tryNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("시도 횟수가 옳바르지 않습니다. 양수로 입력해주세요.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
