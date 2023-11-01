package racingcar.domain.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.ForwardChecker;
import racingcar.domain.NumberGenerator;

class CarTest {

    private static final String CAR1_NAME = "pobi";
    private static final int FORWARD = 4;

    private Car car1;
    private NumberGenerator numberGenerator;
    private ForwardChecker forwardChecker;

    @BeforeEach
    void setUp() {
        car1 = new Car(CarName.from(CAR1_NAME));
        numberGenerator = () -> FORWARD;
        forwardChecker = new ForwardChecker();
    }

    @Test
    void RacingCar_생성시_forwardDistance가_0으로_생성() {
        //then
        assertThat(car1.getForwardDistance()).isEqualTo(0);
    }

    @Test
    void runRound메서드_사용시_forwardDistance가_1증가() {
        //when
        car1.runRound(numberGenerator, forwardChecker);

        //then
        assertThat(car1.getForwardDistance()).isEqualTo(1);
    }

    @Test
    void toString_메서드로_name과_forwardDistance를_출력() {
        //given
        car1.runRound(numberGenerator, forwardChecker);
        car1.runRound(numberGenerator, forwardChecker);
        String expected = CAR1_NAME + " : --";

        //when & then
        assertThat(car1.toString()).isEqualTo(expected);
    }
}