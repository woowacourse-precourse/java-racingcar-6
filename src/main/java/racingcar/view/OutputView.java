package racingcar.view;

import java.util.stream.Collectors;
import racingcar.constant.GameMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.ResultCar;
import racingcar.dto.ResultCars;

public class OutputView {


    private static final String SPACE = " ";
    private static final String COLON = ":";
    private static final String LINE_BREAK = "\n";
    private static final String COMMAS = ",";

    private static final String VISUALIZED_STATUS = "-";

    public OutputView() {
    }

    public void printStartMessage() {
        System.out.println(GameMessage.START_GAME);
    }

    public void printRepeatNumberMessage() {
        System.out.println(GameMessage.REPEAT_NUMBER_REQUEST);
    }

    public void printGameStatusMessage() {
        System.out.println(GameMessage.EXECUTION_RESULT);
    }

    public void printGameStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s" + SPACE + COLON + SPACE + "%s" + LINE_BREAK, car.getName(),
                    appendStatus(car.getDistance()));
        }
        System.out.println();
    }

    private String appendStatus(int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append(VISUALIZED_STATUS);
        }
        return sb.toString();
    }

    public void printRacingCarResult(ResultCars resultCars) {
        System.out.print(GameMessage.FINAL_WINNER + SPACE + COLON + SPACE);

        String resultCarNames = resultCars.getResultCars().stream()
                .map(ResultCar::getName)
                .collect(Collectors.joining(", "));

        System.out.println(resultCarNames);
    }
}
