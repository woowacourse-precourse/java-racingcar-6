package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.constants.Message;
import racingcar.dto.CarResult;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalResult;
import racingcar.dto.Winners;

public class View {
    public View() {

    }

    public String inputCarsName() {
        System.out.println(Message.NAME_INPUT.message());
        return readLine();
    }

    public String inputAttemptCount() {
        System.out.println(Message.ATTEMPT_COUNT_INPUT.message());
        return readLine();
    }

    public void printTotalResult(TotalResult totalResult) {
        blankLine();
        System.out.println(Message.ROUNDS_RESULT.message());

        totalResult.totalResult().forEach(this::printRoundResult);
    }

    private void printRoundResult(RoundResult roundResult) {
        roundResult.roundResult().forEach(this::printCarResult);
        blankLine();
    }

    private void printCarResult(CarResult carResult) {
        System.out.println(carResult.name() + " : " + carResult.forwardState());
    }

    public void printFinalWinnerMessage(Winners winners) {
        System.out.print(Message.WINNERS.message() + winners.name());
    }

    private void blankLine() {
        System.out.println();
    }
}