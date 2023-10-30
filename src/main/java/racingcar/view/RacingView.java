package racingcar.view;

import static racingcar.domain.RacingConfig.NAME_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.FinalRoundResult;
import racingcar.domain.MovementHistory;
import racingcar.domain.SingleRoundResult;
import racingcar.view.enums.RacingMessage;

public class RacingView {
    public String readInput() {
        return Console.readLine();
    }

    public void displayRacingMessage(RacingMessage racingMassage) {
        System.out.println(racingMassage.getMessage());
    }

    public void displayResults(List<SingleRoundResult> results) {
        displayRacingMessage(RacingMessage.RACING_RESULT);
        results.forEach(this::displaySingleRoundResult);
    }

    private void displaySingleRoundResult(SingleRoundResult singleRoundResult) {
        List<Car> cars = singleRoundResult.getCars();
        List<MovementHistory> movementHistories = singleRoundResult.getMovementHistories();

        for (int i = 0; i < movementHistories.size(); i++){
            String formattedResult = formattedMoveHistories(
                    cars.get(i).getName(), trimmedMovedHistories(movementHistories.get(i))
            );
            System.out.println(formattedResult);
        }

        System.out.println();
    }

    public void displayWinnerMessage(FinalRoundResult finalRoundResult) {
        List<String> winnerNames = finalRoundResult.getWinnerNames();
        String formattingNames = String.join(NAME_SEPARATOR , winnerNames);
        String result = String.format(RacingMessage.RACING_WINNER.getMessage(), formattingNames);
        System.out.println(result);
    }

    public String trimmedMovedHistories(MovementHistory carMovementHistory) {
        List<String> movementHistories = carMovementHistory.getMovedHistories();
        return movementHistories.stream()
                .map(movementHistory -> movementHistory.replaceAll("\\s+", ""))
                .collect(Collectors.joining());
    }

    public String formattedMoveHistories(String name, String history){
        return String.format("%s : %s", name, history);
    }
}
