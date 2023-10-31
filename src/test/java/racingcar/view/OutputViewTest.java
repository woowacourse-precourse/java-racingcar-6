package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.position.Position;
import racingcar.domain.power.DefaultPowerGenerator;
import racingcar.dto.RoundResultDto;
import racingcar.service.RefereeService;

@DisplayName("뷰 로직 테스트")
class OutputViewTest {

    private OutputView outputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("라운드 결과를 올바르게 출력한다")
    @Test
    void testShowRoundResult() {
        List<Car> cars = Arrays.asList(
                new Car(new CarName("car1"), new Position(3), new DefaultPowerGenerator()),
                new Car(new CarName("car2"), new Position(5), new DefaultPowerGenerator()),
                new Car(new CarName("car3"), new Position(2), new DefaultPowerGenerator())
        );

        String expectedOutput = "car1 : ---\ncar2 : -----\ncar3 : --";

        outputView.showRoundResult(RoundResultDto.createFrom(cars));
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }

    @DisplayName("복수 우승자일 경우 올바르게 출력한다")
    @Test
    void testShowGameResult() {
        List<Car> cars = Arrays.asList(
                new Car(new CarName("car1"), new Position(3), new DefaultPowerGenerator()),
                new Car(new CarName("car2"), new Position(5), new DefaultPowerGenerator()),
                new Car(new CarName("car3"), new Position(5), new DefaultPowerGenerator())
        );

        String expectedOutput = "최종 우승자 : car2,car3";
        RefereeService refereeService = new RefereeService();
        outputView.showGameResult(refereeService.publishGameResult(cars));
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }

    @DisplayName("단일 우승자일 경우 올바르게 출력한다")
    @Test
    void testShowGameResultWithSingleWinner() {
        List<Car> cars = Arrays.asList(
                new Car(new CarName("car1"), new Position(3), new DefaultPowerGenerator()),
                new Car(new CarName("car2"), new Position(5), new DefaultPowerGenerator()),
                new Car(new CarName("car3"), new Position(2), new DefaultPowerGenerator())
        );

        String expectedOutput = "최종 우승자 : car2";
        RefereeService refereeService = new RefereeService();
        outputView.showGameResult(refereeService.publishGameResult(cars));
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
}