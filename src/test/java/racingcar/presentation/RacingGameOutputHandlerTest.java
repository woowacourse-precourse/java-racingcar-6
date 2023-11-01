package racingcar.presentation;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.constant.RacingGameConstant;
import racingcar.domain.model.Car;
import racingcar.utils.IOHandler;

import java.util.Arrays;
import java.util.List;

public class RacingGameOutputHandlerTest {
    private static final int MOVING_FORWARD = RacingGameConstant.MOVING_FORWARD;
    private static final int STOP = RacingGameConstant.STOP;

    private MockedStatic<IOHandler> mockIOHandler;
    private RacingGameOutputHandler racingGameOutputHandler;

    @BeforeEach
    public void setUp() {
        mockIOHandler = Mockito.mockStatic(IOHandler.class);
        racingGameOutputHandler = RacingGameOutputHandler.getInstance();
    }

    @Test
    public void testPrintRaceStartMessage() {
        racingGameOutputHandler.printRaceStartMessage();
        mockIOHandler.verify(() -> IOHandler.printOutput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"));
    }

    @Test
    public void testPrintTryCountMessage() {
        racingGameOutputHandler.printTryCountMessage();
        mockIOHandler.verify(() -> IOHandler.printOutput("시도할 회수는 몇회인가요?"));
    }

    @Test
    public void testPrintRaceResultHeader() {
        racingGameOutputHandler.printRaceResultHeader();
        mockIOHandler.verify(() -> IOHandler.printOutput("\n실행 결과"));
    }

    @Test
    public void testPrintRaceResult() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        for (int i = 0; i < 3; i++) {
            Assertions.assertRandomNumberInRangeTest(() -> car1.move(), MOVING_FORWARD);
        }
        for (int i = 0; i < 2; i++) {
            Assertions.assertRandomNumberInRangeTest(() -> car2.move(), MOVING_FORWARD);
        }

        List<Car> cars = Arrays.asList(car1, car2);
        racingGameOutputHandler.printRaceResult(cars);

        mockIOHandler.verify(() -> IOHandler.printOutput("car1 : ---"));
        mockIOHandler.verify(() -> IOHandler.printOutput("car2 : --"));
        mockIOHandler.verify(() -> IOHandler.printOutput(""));
    }

    @Test
    public void testPrintWinners() {
        List<Car> winners = Arrays.asList(new Car("car1"), new Car("car2"));
        racingGameOutputHandler.printWinners(winners);

        mockIOHandler.verify(() -> IOHandler.printOutput("최종 우승자 : car1, car2"));
    }

    @AfterEach
    public void tearDown() {
        mockIOHandler.close();
    }
}