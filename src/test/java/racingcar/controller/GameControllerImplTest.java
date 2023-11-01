package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static racingcar.constants.CarRandomCondition.MOVING_FORWARD;
import static racingcar.constants.CarRandomCondition.STOP;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.PrintOutputTest;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.output.ConsoleOutputView;
import racingcar.vo.CarList;
import racingcar.vo.CarListFactory;

public class GameControllerImplTest extends PrintOutputTest {

    @Test
    void getCarList_메소드_자동차_이름을_입력받아_CarList_생성() {
        final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        final ConsoleInputView mockConsoleInputView = mock(ConsoleInputView.class);
        final GameControllerImpl gameController = new GameControllerImpl(consoleOutputView, mockConsoleInputView);

        final String actualInput = "pobi, woni, jun";
        when(mockConsoleInputView.readCarNames()).thenReturn(actualInput);

        final CarList expected = CarListFactory.create(actualInput);
        final CarList actual = gameController.getCarList();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getTryCount_메소드_횟수_입력() {
        final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        final ConsoleInputView mockConsoleInputView = mock(ConsoleInputView.class);
        final GameControllerImpl gameController = new GameControllerImpl(consoleOutputView, mockConsoleInputView);

        final int expected = 5;
        when(mockConsoleInputView.readTryCount()).thenReturn(expected);

        final int actual = gameController.getTryCount();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void printExecutionResult_메소드_모든_Car_목록의_경주_현황을_출력() {
        final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        final ConsoleInputView mockConsoleInputView = mock(ConsoleInputView.class);
        final GameControllerImpl gameController = new GameControllerImpl(consoleOutputView, mockConsoleInputView);

        final CarList carList = CarListFactory.create("pobi, woni, jun");
        gameController.createCarViews(carList);

        final RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);
        when(mockGenerator.generate()).thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP);
        carList.getCarList().stream().forEach(car -> car.setNumberGenerator(mockGenerator));

        final int expectedTryCount = 1;
        gameController.printExecutionResult(expectedTryCount, carList);

        assertThat(output()).isEqualTo("실행 결과\npobi : -\nwoni : -\njun : ".trim());
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.")
    void 최종_우승자를_출력() {
        final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        final ConsoleInputView mockConsoleInputView = mock(ConsoleInputView.class);
        final GameControllerImpl gameController = new GameControllerImpl(consoleOutputView, mockConsoleInputView);

        final CarList carList = CarListFactory.create("pobi, woni, jun");

        final RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);
        when(mockGenerator.generate()).thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP);
        carList.getCarList().stream().forEach(car -> car.setNumberGenerator(mockGenerator));

        carList.moveForward();
        gameController.printWinners(carList);

        assertThat(output()).isEqualTo("최종 우승자 : pobi, woni");
    }
}
