package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.constants.Message;
import racingcar.dto.CarResult;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalResult;
import racingcar.model.Winners;

public class View {
    public View() {

    }

    public String inputConsole() {
        return readLine();
    }

    public void printTotalResult(TotalResult totalResult) {
        System.out.println();
        System.out.println(Message.ROUNDS_RESULT.message());

        totalResult.totalResult().forEach(this::printRoundResult);
    }

    private void printRoundResult(RoundResult roundResult) {
        roundResult.roundResult().forEach(this::printCarResult);
        System.out.println();
    }

    private void printCarResult(CarResult carResult) {
        System.out.println(carResult.name() + " : " + carResult.forwardState());
    }

    public void printNameInputMessage() {
        System.out.println(Message.NAME_INPUT.message());
    }

    public void printAttemptCountInputMessage() {
        System.out.println(Message.ATTEMPT_COUNT_INPUT.message());
    }

    public void printFinalWinnerMessage(Winners winnersResult) {
        System.out.print(Message.WINNERS.message() + winnersResult.getWinners());
    }
}