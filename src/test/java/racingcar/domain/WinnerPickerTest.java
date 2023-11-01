package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class WinnerPickerTest {

    private WinnerPicker winnerPicker;
    private Cars cars;
    private CarNames carNames;
    private RandomNumberGenerator randomNumberGenerator;
    private ForwardChecker forwardChecker;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";
    private static final String CAR4_NAME = "umi";
    private static final int STOP = 3;
    private static final int FORWARD = 4;

    @BeforeEach
    void setUp() {
        winnerPicker = new WinnerPicker();
        randomNumberGenerator = new RandomNumberGenerator();
        forwardChecker = new ForwardChecker();
    }

    @Test
    void 우승자가_한명인_경우_pickWinner_메서드로_우승자의_이름리스트를_반환() {
        //given
        carNames = new CarNames(Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME));
        cars = new Cars(carNames);

        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(STOP, STOP, FORWARD);

            cars.runRound(randomNumberGenerator, forwardChecker);

            //when
            Winners winners = winnerPicker.pickWinner(cars);

            //then
            assertThat(winners.getWinnersName().getCarNames().size()).isEqualTo(1);
            assertThat(winners.getWinnersName().getCarNames()).contains(new CarName(CAR3_NAME));
        }
    }

    @Test
    void 우승자가_두명인_경우_pickWinner_메서드로_우승자의_이름리스트를_반환() {
        //given
        carNames = new CarNames(Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME, CAR4_NAME));
        cars = new Cars(carNames);

        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(STOP, STOP, FORWARD, FORWARD);

            cars.runRound(randomNumberGenerator, forwardChecker);

            //when
            Winners winners = winnerPicker.pickWinner(cars);

            //then
            assertThat(winners.getWinnersName().getCarNames().size()).isEqualTo(2);
            assertThat(winners.getWinnersName().getCarNames()).contains(new CarName(CAR3_NAME), new CarName(CAR4_NAME));
        }
    }
}
