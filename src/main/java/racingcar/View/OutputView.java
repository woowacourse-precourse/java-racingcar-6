package racingcar.View;

import racingcar.model.Car;
import racingcar.model.Positions;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String PROGRESS_BAR_ELEM = "-";
    private final PrintStream printStream;

    public OutputView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printExecuteResultMessage() {
        printStream.println();
        printStream.println("실행 결과");
    }

    public void printPositions(Positions positions) {
        for (String name : positions.getNames()) {
            String progressBar = progressBar(positions, name);
            printStream.println(name + " : " + progressBar);
        }
        printStream.println();
    }

    private String progressBar(Positions positions, String name) {
        return PROGRESS_BAR_ELEM.repeat(positions.getPositionByName(name));
    }

    public void printWinners(List<Car> winners) {
        String winnersName = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        printStream.println("최종 우승자 : " + winnersName);
    }
}
