package racingcar.view;

import static racingcar.utils.RacingConfig.NAME_SEPARATOR;
import static racingcar.utils.RacingConfig.OUTPUT_PATTERN;
import static racingcar.utils.RacingConfig.WINNER_OUTPUT_PATTERN;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.result.CarResult;
import racingcar.domain.result.FinalResult;
import racingcar.domain.result.RoundResult;
import racingcar.view.message.RacingMessage;

public class RacingView {
    public String readInput() {
        return Console.readLine();
    }

    public void displayRacingMessage(RacingMessage racingMassage) {
        System.out.println(racingMassage.getMessage());
    }
    public void displayFinalResult(FinalResult finalFinalResult) {
        System.out.println();
        displayRacingMessage(RacingMessage.RACING_RESULT);
        List<RoundResult> roundResults = finalFinalResult.getRoundResults();
        roundResults.forEach(this::displayRoundResult);
    }
    private void displayRoundResult(RoundResult roundResult) {
        List<CarResult> carResults = roundResult.getCarResults();
        for (CarResult carResult : carResults) {
            printCarResult(carResult);
        }
        System.out.println();
    }
    public void displayWinner(FinalResult finalResult) {
        List<String> winnerNames = finalResult.getWinnerNames();
        printWinnerName(String.join(NAME_SEPARATOR + " ", winnerNames));
    }

    private void printCarResult(CarResult carResult) {
        String carMoveHistory = formattedMoveHistories(carResult.getName(), carResult.getDistanceMark());
        System.out.println(carMoveHistory);
    }
    private void printWinnerName(String formattedNames) {
        String winner = formattedWinner(formattedNames);
        System.out.println(winner);
    }

    private String formattedMoveHistories(String name, String history){
        return String.format(OUTPUT_PATTERN, name, history);
    }
    private String formattedWinner(String formattingNames) {
        return String.format(WINNER_OUTPUT_PATTERN, formattingNames);
    }

}
