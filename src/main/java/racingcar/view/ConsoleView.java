package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class ConsoleView implements View{

    @Override
    public List<String> requestRacerNames() {
        OutputConsole.printRequestRacerNames();
        return InputConsole.readRacerNames();
    }

    @Override
    public int requestRaceNumberOfTime() {
        OutputConsole.printRequestRaceNumberOfTime();
        return InputConsole.readRaceNumberOfTime();
    }

    @Override
    public void displayRaceResult() {
        OutputConsole.printEmptyLine();
        OutputConsole.printResultMessage();
    }

    @Override
    public void displayRaceStatus(List<Car> cars) {
        cars.forEach(car -> {
            OutputConsole.printCarStatus(car.getName(), car.getMovementDistance());
        });
        OutputConsole.printEmptyLine();
    }

    @Override
    public void displayWinner(List<String> winner) {
        OutputConsole.printWinner(winner);
    }
}
