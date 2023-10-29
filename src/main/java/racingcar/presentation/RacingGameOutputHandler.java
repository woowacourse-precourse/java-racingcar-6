package racingcar.presentation;

import racingcar.domain.model.Car;
import racingcar.utils.IOHandler;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameOutputHandler {
    private static final RacingGameOutputHandler instance = new RacingGameOutputHandler();

    private RacingGameOutputHandler() {
    }

    public static RacingGameOutputHandler getInstance() {
        return instance;
    }

    public void printRaceStartMessage() {
        IOHandler.printOutput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountMessage() {
        IOHandler.printOutput("시도할 회수는 몇회인가요?");
    }

    public void printRaceResultHeader() {
        IOHandler.printOutput("\n실행 결과");
    }

    public void printRaceResult(List<Car> cars) {
        cars.forEach(this::printCarPosition);
        IOHandler.printOutput("");
    }

    private void printCarPosition(Car car) {
        String positionRepresentation = "-".repeat(car.getPosition());
        IOHandler.printOutput(car.getName() + " : " + positionRepresentation);
    }

    public void printWinners(List<Car> winners) {
        String winnerOutput = "최종 우승자 : " + winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        IOHandler.printOutput(winnerOutput);
    }
}
