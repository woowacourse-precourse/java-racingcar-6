package racingcar.game.outputgeneratemanager;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.Car;
import racingcar.game.car.CarFactory;
import racingcar.game.director.Rule;
import racingcar.game.director.Simulator;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;

class OutputGenerateManagerTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final Rule rule = new Rule();
    private final OutputGenerateManager outputGenerateManager = new OutputGenerateManager(rule);
    private final List<String> NAME_LIST = Arrays.asList("한놈", "두식이", "석삼", "너구리");

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
        //given
        InputGenerateManagerImpl mockInputGenerateManager = Mockito.mock(InputGenerateManagerImpl.class);
        CarFactory carFactory = new CarFactory(mockInputGenerateManager);
        Mockito.when(mockInputGenerateManager.generateRandomInt()).thenReturn(4, 3, 4, 2);
        Simulator simulator = new Simulator();
        List<Car> cars = carFactory.createCars(NAME_LIST);

        //when
        simulator.perRound(cars);
        outputGenerateManager.printWinners(cars);

        //then
        Assertions.assertThat(outContent.toString()).isEqualTo("한놈, 석삼" + System.lineSeparator());
    }

    @Test
    void 기타_출력_메서드_확인() {
        //when
        outputGenerateManager.printRepeatCountAnnounce();

        //then
        Assertions.assertThat(outContent.toString()).isEqualTo("시도할 회수는 몇회인가요?" + System.lineSeparator());
    }
}