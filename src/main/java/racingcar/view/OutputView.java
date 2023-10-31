package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.enums.OutputMessage;

public final class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public static void printGameResultInfo() {
        System.out.println(OutputMessage.GAME_RESULT_INFO_MESSAGE.getValue());
    }

    public static void printUnitGameResult(List<Car> cars) {
        cars.forEach(OutputView::printCarPosition);
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        String stringBuilder = car.getName()
                + OutputMessage.NAME_POSITION_DELIMITER.getValue()
                + String.valueOf(OutputMessage.RACE_MARK.getValue())
                .repeat(Math.max(0, car.getPosition()));
        System.out.println(stringBuilder);
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(OutputMessage.WINNER_INFO_MESSAGE.getValue()
                + OutputMessage.NAME_POSITION_DELIMITER.getValue()
                + winners.stream().
                        map(Car::getName).
                        collect(Collectors.joining(", ")));
    }
}
