package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
public class RacingCarTest {

    private static RacingCar racingCar;

    @BeforeAll
    static void initRacingCar() {
        racingCar = new RacingCar("racingA");
    }

    @ParameterizedTest
    @ValueSource(strings = {"twosome", "starbucks", "megacoffee"})
    void 이름을_가진_레이싱카_생성(String name) {
        RacingCar car = new RacingCar(name);
        assertThat(car.toString()).isEqualTo("name : " + name);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9})
    void 레이싱카가_전진한다(int random) {
        boolean isMove = racingCar.moveBy(random);
        assertThat(isMove).isTrue();
    }

    @ParameterizedTest
    @CsvSource("0, 1, 2, 3, 4")
    void 레이싱카가_전진하지_않는다(int random) {
        boolean isMove = racingCar.moveBy(random);
        assertThat(isMove).isFalse();
    }

    @RepeatedTest(10)
    void 레이싱카가_전진도하고_후진도_한다() {
        int number = Randoms.pickNumberInRange(0, 9);
        System.out.println("number = " + number);
        assertThat(racingCar.moveBy(number)).isIn(true, false);
    }

    @RepeatedTest(10)
    void 입력값_범위로인해_에러_발생_양수() {
        int number = Randoms.pickNumberInRange(10, 100);
        System.out.println("number = " + number);
        Assertions.assertThatThrownBy(() -> racingCar.moveBy(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(10)
    void 입력값_범위로인해_에러_발생_음수() {
        int number = Randoms.pickNumberInRange(-100, -1);
        System.out.println("number = " + number);
        Assertions.assertThatThrownBy(() -> racingCar.moveBy(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @AfterAll
    static void close() {
        racingCar = null;
    }
}
