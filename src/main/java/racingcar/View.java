package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    public View() {

    }

    public String inputConsole() {
        return readLine();
    }

    public void printCurrentCarsResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCurrentCarResult(car);
        }
        System.out.println();
    }

    public void printCurrentCarResult(Car car) {
        System.out.println(car.getNameValue() + " : " + car.getCurrentPositionStatus());
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

    public void printFinalWinnerMessage(String result) {
        System.out.println();
        System.out.print(Message.WINNERS.message() + result);
    }
}
