package racingcar.game;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic.Verification;
import org.mockito.Mockito;
import racingcar.game.car.Car;
import racingcar.game.director.Round;
import racingcar.game.director.Simulator;

class SimulatorTest {
    private final static Car CAR_A = Mockito.mock(Car.class);
    private final static Car CAR_B = Mockito.mock(Car.class);
    private final static Car CAR_C = Mockito.mock(Car.class);
    private final static Car CAR_D = Mockito.mock(Car.class);
    private final static List<Car> CAR_LIST = Arrays.asList(CAR_A, CAR_B, CAR_C, CAR_D);
    private final static Simulator simulator = new Simulator();


    @Test
    void 라운드_진행시_Car_drive_호출() {

        simulator.perRound(CAR_LIST);

        Mockito.verify(CAR_A).drive();
        Mockito.verify(CAR_B).drive();
        Mockito.verify(CAR_C).drive();
        Mockito.verify(CAR_D).drive();

    }
}