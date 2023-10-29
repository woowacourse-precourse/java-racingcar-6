package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.Message;
import racingcar.dto.CarState;
import racingcar.dto.CarsState;
import racingcar.dto.WinnersDto;

public class View {
    public View() {

    }

    public String inputConsole() {
        return readLine();
    }

    public void printCurrentCarsResult(CarsState carsState) {
        carsState.carsState().forEach(this::printCurrentCarResult);
        System.out.println();
    }

    public void printCurrentCarResult(CarState carResult) {
        System.out.println(carResult.name() + " : " + carResult.forwardState().forwardState());
    }

    public void printNameInputMessage() {
        System.out.println(Message.NAMEINPUT.message());
    }

    public void printAttemptCountInputMessage() {
        System.out.println(Message.ATTEMPTCOUNTINPUT.message());
    }

    public void printAttemptResultMessage() {
        System.out.println();
        System.out.println(Message.ATTEMPTRESULT.message());
    }

    public void printFinalWinnerMessage(WinnersDto winnersDto) {
        System.out.println();
        System.out.print(Message.WINNERS.message() + winnersDto.winners());
    }
}
