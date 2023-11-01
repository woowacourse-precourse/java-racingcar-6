package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class CarsTest {

    private Cars cars;
    private CarNames carNames;
    private NumberGenerator numberGenerator;
    private ForwardChecker forwardChecker;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";
    private static final int STOP = 3;
    private static final int FORWARD = 4;

    @BeforeEach
    void setUp() {
        carNames = new CarNames(Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME));
        cars = new Cars(carNames);
    }

    @Test
    void 자동차_3대가_Cars에_포함() {
        List<Car> carList = cars.getCars();

        //then
        assertThat(carList.size())
                .isEqualTo(3);

        assertThat(carList)
                .extracting("name")
                .contains(CAR1_NAME, CAR2_NAME, CAR3_NAME);
    }

    @Test
    void runRound메서드로_3대_자동차_모두_한번_전진() {
        //when
        numberGenerator = () -> FORWARD;
        forwardChecker = new ForwardChecker();
        cars.runRound(numberGenerator, forwardChecker);

        //then
        for (Car car: cars.getCars()) {
            assertThat(car.getForwardDistance())
                    .isEqualTo(1);
        }
    }

    @Test
    void getMaxForwardDistance메서드로_가장_큰_전진거리() {
        //given
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(STOP, STOP, FORWARD, STOP, FORWARD, FORWARD);

            cars.runRound(new RandomNumberGenerator(), new ForwardChecker());
            cars.runRound(new RandomNumberGenerator(), new ForwardChecker());
        }

        //when
        int actualMaxForwardDistance = cars.getMaxForwardDistance();

        //then
        assertThat(actualMaxForwardDistance).isEqualTo(2);
    }
}