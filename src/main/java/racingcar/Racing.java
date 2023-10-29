package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Racing {
    // Class instance
    private Car car;
    private Output output;

    // Constructor
    public Racing() {
        car = new Car();
        output = new Output();
    }

    //method
    public void start() {
        getUserCarNameByConsole();
        getUserRoundNumberByConsole();
        output.printRoundResultAnnouncement();
        carRacing();
        winnerSearchAndPrint();
    }

    public void getUserCarNameByConsole() {
        output.printUserNameInputAnnouncement();
        String consoleInput = Console.readLine();
        car.insertUserName(consoleInput);
        car.checkUserNameError();
    }

    public void getUserRoundNumberByConsole() {
        output.printUserRoundInputAnnouncement();
        String consoleInput = Console.readLine();
        car.insertRoundNumber(consoleInput);
        car.checkRoundNumberError();
    }

    public void carRacing() {
        car.resetUserMovementArraylist();
        int maxUser = car.howManyUser();
        int maxRound = car.howManyRound();
        for (int i = 0; i < maxRound; i++) {
            for (int index = 0; index < maxUser; index++) {
                car.plusMovement(index);
            }
            printRoundResult();
        }
    }

    public void winnerSearchAndPrint() {
        car.searchWinner();
        printWinner();
    }

    public void printRoundResult() {
        int numberOfUser = car.howManyUser();
        for (int index = 0; index < numberOfUser; index++) {
            String indexUserName = car.returnIndexUserName(index);
            int indexUserMovement = car.returnIndexUserMovement(index);
            output.printUserRoundResult(indexUserName, indexUserMovement);
        }
        output.printGap();
    }

    public void printWinner() {
        String winner = car.whoIsWinner();
        output.printWinner(winner);
    }

}
