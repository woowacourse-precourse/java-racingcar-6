package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.RacingMessage;
import racingcar.model.Car;
import racingcar.validator.InputValidator;

public class RacingView {

    private static final String CAR_NAME_SEPARATOR = ",";
    private static final String RACING_PROGRESS_FORMAT = "%s : %s";
    private static final String RACING_PROGRESS_BAR = "-";
    private static final String WINNER_NAME_SEPARATOR = ", ";

    public List<Car> inputCarNames() {
        System.out.println(RacingMessage.INPUT_CAR_NAME);
        return Arrays.stream(Console.readLine().split(CAR_NAME_SEPARATOR)).map(Car::new).collect(
            Collectors.toList());
    }

    public Integer inputTryCount() {
        System.out.println(RacingMessage.INPUT_TRY_COUNT);
        String input = Console.readLine();
        InputValidator.validateTryCountInput(input);
        return Integer.parseInt(input);
    }

    public void startPrintTryResult() {
        System.out.println(RacingMessage.TRY_RESULT);
    }

    public void showRacingProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getRacingProgress(car.getName(), car.getMoveCount()));
        }
        System.out.println();
    }

    public void showRacingWinner(List<Car> cars) {
        Integer maxCount = cars.stream()
            .mapToInt(Car::getMoveCount)
            .max().getAsInt();
        String maxCountCarNames = cars.stream()
            .filter(car -> car.getMoveCount() == maxCount)
            .map(Car::getName)
            .collect(Collectors.joining(WINNER_NAME_SEPARATOR));
        System.out.println(RacingMessage.RACING_WINNER + maxCountCarNames);
    }

    private String getRacingProgress(String carName, Integer moveCount) {
        return String.format(RACING_PROGRESS_FORMAT, carName,
            RACING_PROGRESS_BAR.repeat(moveCount));
    }
}
