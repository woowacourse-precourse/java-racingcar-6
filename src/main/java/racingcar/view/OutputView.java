package racingcar.view;

import java.util.List;
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName())
                .append(OutputMessage.NAME_POSITION_DELIMITER.getValue());
        stringBuilder.append(String.valueOf(OutputMessage.RACE_MARK.getValue())
                .repeat(Math.max(0, car.getPosition())));
        System.out.println(stringBuilder);
    }
}
