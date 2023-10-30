package racingcar.view;

import static racingcar.utils.RacingConfig.NAME_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.result.FinalResult;
import racingcar.domain.movement.MovementHistory;
import racingcar.domain.result.RoundResult;
import racingcar.view.message.RacingMessage;

public class RacingView {
    public String readInput() {
        return Console.readLine();
    }

    public void displayRacingMessage(RacingMessage racingMassage) {
        System.out.println(racingMassage.getMessage());
    }
    public void displayResults(List<RoundResult> roundResults) {
        displayRacingMessage(RacingMessage.RACING_RESULT);
        roundResults.forEach(this::displayRoundResult);
    }
    private void displayRoundResult(RoundResult roundResult) {
        List<Car> cars = roundResult.getCars();
        List<MovementHistory> movementHistories = roundResult.getMovementHistories();

        for (int i = 0; i < cars.size(); i++){
            String formattedResult = formattedMoveHistories(
                    cars.get(i).getName(), trimmedMovedHistories(movementHistories.get(i))
            );
            System.out.println(formattedResult);
        }
        System.out.println();
    }
    public void displayWinnerMessage(FinalResult finalFinalResult) {
        List<String> winnerNames = finalFinalResult.getWinnerNames();
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
