package racingcar.game.outputgeneratemanager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.game.Rule;
import racingcar.game.Simulator;
import racingcar.game.car.Car;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;

class OutputGenerateManagerTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 우승자_확인() {
        Rule rule = new Rule();

        List<String> racingCarNameList = Arrays.asList("한놈","두식이","석삼","너구리");
        InputGenerateManagerImpl mockInputGenerateManager = Mockito.mock(InputGenerateManagerImpl.class);
        Mockito.when(mockInputGenerateManager.generateRandomInt())
                .thenReturn(4,3,4,2);

        Simulator simulator = new Simulator(mockInputGenerateManager);
        List<Car> cars = simulator.nameToRacingCar(racingCarNameList);
        OutputGenerateManager outputGenerateManager = new OutputGenerateManager(rule);

        //when
        simulator.perRound(cars);
        outputGenerateManager.printWinners(cars);


        //then
        Assertions.assertThat(outContent.toString()).isEqualTo("한놈, 석삼"+System.lineSeparator());

    }
}