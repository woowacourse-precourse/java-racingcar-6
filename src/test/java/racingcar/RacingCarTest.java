package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void initRacingCar() {
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

    @Test
    void 레이싱카가_전진_5번() {
        for (int i = 0; i < 5; i++) {
            racingCar.moveBy(5);
        }
        assertThat(racingCar.getPosition()).isEqualTo(5);
    }

}
