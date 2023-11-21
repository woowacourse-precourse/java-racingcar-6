package racingcar.view;

import java.util.List;
import racingcar.RacingConst;
import racingcar.domain.car.Car;
import racingcar.view.io.Writer;

public class OutputView {
    private static final String DISTANCE_TOKEN = "-";
    private final Writer writer = new Writer();

    public void printResultTitle() {
        writer.printMessage("");
        writer.printMessage("실행 결과");
    }

    public void printRountResult(List<Car> cars) {
        cars.forEach(
                car ->
                        writer.printMessageUsingFormat("%s : %s", car.getName(), getPositionString(car)));
        writer.printMessage("");
    }

    private String getPositionString(Car car) {
        return DISTANCE_TOKEN.repeat(car.getPosition());
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(RacingConst.WINNER_DELIMITER, winnerNames);
        writer.printMessage("최종 우승자 : " + winners);
    }
}
