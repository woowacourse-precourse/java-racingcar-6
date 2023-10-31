package racingcar.game;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.Car;
import racingcar.game.director.Simulator;

class SimulatorTest {

    private List<Car> carList;
    private Car mockCarA;
    private Car mockCarB;
    private Car mockCarC;
    private Car mockCarD;
    private final Simulator simulator = new Simulator();

    @BeforeEach
    public void setCars() {
        mockCarA = Mockito.mock(Car.class);
        mockCarB = Mockito.mock(Car.class);
        mockCarC = Mockito.mock(Car.class);
        mockCarD = Mockito.mock(Car.class);
        carList = Arrays.asList(mockCarA, mockCarB, mockCarC, mockCarD);
    }


    @Test
    void 라운드_진행시_Car_forwardCount_확인() {
        simulator.perRound(carList);

        Mockito.verify(mockCarA).drive();
        Mockito.verify(mockCarB).drive();
        Mockito.verify(mockCarC).drive();
        Mockito.verify(mockCarD).drive();

    }
}