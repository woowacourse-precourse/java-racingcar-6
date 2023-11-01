package racingcar.validation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
    private static Validation validation;

    @BeforeAll
    static void setUp() {
        validation = new Validation();
    }

    @Nested
    @DisplayName("자동차 이름 예외 테스트")
    class CarNameValidator {

        @ParameterizedTest
        @ValueSource(strings = {"pobi,gabi,가나다,123,car1,1자동차", "pobi"})
        void 자동차_컴마로_구분_테스트(String carNames) {
            assertThatCode(() -> validation.checkCarNameInputForm(carNames))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"pobi,gabi/가나다,123,car1,1자동차", "pobi/gabi"})
        void 자동차_컴마로_구분_예외_테스트(String carNames) {
            assertThatThrownBy(() -> validation.checkCarNameInputForm(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContainingAll("입력 구분을 ,로 하지 않았습니다.");
        }

        @Test
        void 자동차_입력_길이_테스트() {
            Car car = new Car("robin");

            assertThatCode(() -> validation.checkCarNameForm(car.getName()))
                    .doesNotThrowAnyException();
        }

        @Test
        void 자동차_입력_길이_예외_테스트() {
            Car car = new Car("robinh");

            assertThatThrownBy(() -> validation.checkCarNameForm(car.getName()))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContainingAll("자동차 이름은 길이는 5이하 입니다.");
        }

        @Test
        void 자동차_이름_중복_테스트() {
            Car car1 = new Car("robih");
            Car car2 = new Car("robih");
            List<String> carNames = new ArrayList<>(List.of(car1.getName(), car2.getName()));

            assertThatThrownBy(() -> validation.checkDuplicateCarName(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContainingAll("차 이름이 중복됐습니다.");
        }

        @Test
        void 자동차_개수_테스트() {
            Car car1 = new Car("robih");
            Car car2 = new Car("robin");
            List<String> carNames = new ArrayList<>(List.of(car1.getName(), car2.getName()));

            assertThatCode(() -> validation.checkCarNum(carNames))
                    .doesNotThrowAnyException();
        }

        @Test
        void 자동차_개수_예외_테스트() {
            Car car1 = new Car("robih");
            List<String> carNames = new ArrayList<>(List.of(car1.getName()));

            assertThatThrownBy(() -> validation.checkCarNum(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContainingAll("차는 2대 이상 이여야 경주가 가능합니다.");
        }
    }

    @Nested
    @DisplayName("시도 횟수 예외 테스트")
    class TryNumValidator {

        @Test
        void 시도_횟수_정수_확인_예외_테스트 () {
            String tryNum = "tryNum";

            assertThatThrownBy(() -> validation.checkTryNumType(tryNum))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContainingAll("시도 횟수에 대한 입력이 정수가 아닙니다.");
        }

        @ParameterizedTest
        @ValueSource(ints = {-12, 0})
        void 시도_횟수_양수_확인_예외_테스트(int tryNum) {
            assertThatThrownBy(() -> validation.checkTryNum(tryNum))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContainingAll("시도 횟수가 옳바르지 않습니다. 양수로 입력해주세요.");
        }
    }
}