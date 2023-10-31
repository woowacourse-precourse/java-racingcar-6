package racingcar.game.director;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.Car;
import racingcar.game.car.CarFactory;
import racingcar.game.inputgenerateManager.InputGenerateManager;
import racingcar.game.outputgeneratemanager.OutputGenerateManager;

class DirectorTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private InputGenerateManager inputGenerateManager;
    private OutputGenerateManager outputGenerateManager;
    private Simulator simulator;
    private CarFactory carFactory;
    private Director director;

    @BeforeEach
    void setUp() {
        inputGenerateManager = Mockito.mock(InputGenerateManager.class);
        outputGenerateManager = Mockito.mock(OutputGenerateManager.class);
        simulator = Mockito.mock(Simulator.class);
        carFactory = Mockito.mock(CarFactory.class);
        director = new Director(inputGenerateManager, outputGenerateManager, simulator, carFactory);

    }

    @BeforeEach
    public void setUpPrintStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 메서드_호출_확인() {
        //given
        String carNames = "car1,car2,car3";
        String repeatCount = "5";
        List<String> carNameList = Arrays.asList("car1", "car2", "car3");
        List<Car> cars = carFactory.createCars(carNameList);

        Round mockRound = Mockito.mock(Round.class);
        Mockito.when(simulator.perRound(cars)).thenReturn(mockRound);

        Mockito.when(inputGenerateManager.generateInputStringSplitWithComma(carNames)).thenReturn(carNameList);
        Mockito.when(inputGenerateManager.generateInputStringToInt(repeatCount)).thenReturn(5);

        ByteArrayInputStream in = new ByteArrayInputStream(
                (carNames + System.lineSeparator() + repeatCount).getBytes());
        System.setIn(in);

        //when
        director.startProcess();

        //then
        Mockito.verify(outputGenerateManager).printCarNameAnnounce();
        Mockito.verify(outputGenerateManager).printRepeatCountAnnounce();
        Mockito.verify(outputGenerateManager, Mockito.times(5)).printResultList(Mockito.any(Round.class));
        Mockito.verify(outputGenerateManager).printWinnerAnnounce();
        Mockito.verify(outputGenerateManager).printWinners(cars);

        System.setIn(System.in);

    }
}