package racingcar.view;

import static racingcar.view.output.constant.OutputFormatConstant.PRINT_CAR_NAME_AND_DISTANCE_FORMAT;
import static racingcar.view.output.constant.OutputMessageConstant.EXECUTION_START_SIGN;
import static racingcar.view.output.constant.OutputMessageConstant.FINAL_WINNER_ANNOUNCEMENT_SIGN;
import static racingcar.view.output.constant.OutputMessageConstant.INSERT_CAR_NAMES_DIRECTION;
import static racingcar.view.output.constant.OutputMessageConstant.INSERT_TRIAL_TIMES_DIRECTION;
import static racingcar.view.output.constant.OutputSymbolConstant.CAR_DISTANCE_VALUE_SYMBOL;
import static racingcar.view.output.constant.OutputSymbolConstant.FINAL_WINNER_DUPLICATE_DELIMITER;
import static racingcar.view.output.constant.OutputSymbolConstant.NEW_LINE;

import java.util.Map;
import java.util.stream.Collectors;
import racingcar.dto.CarNamesWithDistanceDto;
import racingcar.dto.WinnerNamesDto;

public class OutputView {
    public void askToInsertCarNameList() {
        print(INSERT_CAR_NAMES_DIRECTION.getMessage());
        printLine();
    }

    public void askToInsertTrialTimes() {
        print(INSERT_TRIAL_TIMES_DIRECTION.getMessage());
        printLine();
    }

    public void printExecutionStartSign() {
        printLine();
        print(EXECUTION_START_SIGN.getMessage());
        printLine();
    }

    public void printCarStatus(CarNamesWithDistanceDto carNamesWithDistanceDto) {
        printCarNameAndDistance(carNamesWithDistanceDto);
        printLine();
    }

    private void printCarNameAndDistance(CarNamesWithDistanceDto carNamesWithDistanceDto) {
        Map<String, Integer> carNamesWithDistance = carNamesWithDistanceDto.carNamesWithDistance();
        carNamesWithDistance.forEach(
                (carName, distance) -> {
                    print(
                            String.format(PRINT_CAR_NAME_AND_DISTANCE_FORMAT.getFormat(),
                                    carName,
                                    convertToSymbol(distance))
                    );
                    printLine();
                }
        );
    }

    private String convertToSymbol(int distance) {
        return CAR_DISTANCE_VALUE_SYMBOL.getSymbol().repeat(distance);
    }

    public void printFinalWinner(WinnerNamesDto winnerNamesDto) {
        print(FINAL_WINNER_ANNOUNCEMENT_SIGN.getMessage());
        String gameResult = winnerNamesDto.winnerNames().stream()
                .collect(Collectors.joining(FINAL_WINNER_DUPLICATE_DELIMITER.getSymbol()));
        print(gameResult);
        printLine();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void printLine() {
        print(NEW_LINE.getSymbol());
    }
}