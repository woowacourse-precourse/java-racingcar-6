package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3"})
    void 차_이름_입_기능_검증_테스트(String inputCarNames) {
        String[] carNames = inputCarNames.split(",");

        boolean result = Application.validateCarNames(carNames);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"supercar,car1,car"})
    void 차_이름_입력_예외_처리_테스트(String inputCarNames) {
        String[] carNames = inputCarNames.split(",");

        boolean result = Application.validateCarNames(carNames);

        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"4"})
    void 시도_횟수_입력_테스트(String inputAttemptsNum) {
        boolean result = Application.validateAttemptsNum(inputAttemptsNum);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1"})
    void 시도_횟수_입력_예외_처리_테스트(String inputAttemptsNum) {
        boolean result = Application.validateAttemptsNum(inputAttemptsNum);

        assertThat(result).isFalse();
    }

    @Test
    void 자동차_객체_생성_테스트() {
        String[] carNames = new String[] {"car1", "car2", "car3"};

        List<Car> cars = Application.createCars(carNames);

        assertAll(
                () -> assertThat(cars).extracting("carName")
                        .isEqualTo(Arrays.asList("car1", "car2", "car3")),
                () -> assertThat(cars).extracting("location")
                        .isEqualTo(Arrays.asList(0, 0, 0))
        );
    }

    @Test
    void 자동차_전진_기능_테스트() {
        String[] carNames = new String[] {"car1", "car2"};

        List<Car> cars = Application.createCars(carNames);
        Application.moveCars(cars);
        boolean valid = cars.stream()
                .map(Car::getLocation)
                .anyMatch(location -> location == 0 || location == 1);

        assertAll(
                () -> assertThat(cars).extracting("carName")
                        .isEqualTo(Arrays.asList("car1", "car2")),
                () -> assertThat(valid).isTrue()
        );
    }

    @Test
    void 자동차_전진_반복_테스트() {
        String[] carNames = new String[] {"car1", "car2"};

        List<Car> cars = Application.createCars(carNames);
        int attemptsNum = 4;
        Application.repeatAttempts(attemptsNum, cars);

        boolean valid = cars.stream()
                .map(Car::getLocation)
                .anyMatch(location -> location == 0
                        || location == 1
                        || location == 2
                        || location == 3
                        || location == 4
                );

        assertAll(
                () -> assertThat(cars).extracting("carName")
                        .isEqualTo(Arrays.asList("car1", "car2")),
                () -> assertThat(valid).isTrue()
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
