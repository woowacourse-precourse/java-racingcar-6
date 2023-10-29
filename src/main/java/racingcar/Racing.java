package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Racing {
    // Class instance
    Car car;
    Output output;

    // Constructor
    public Racing() {
        car = new Car();
        output = new Output();
    }

    //method
    public void start() {
        getUserCarNameByConsole();
        getUserRoundNumberByConsole();
        carRacing();
        car.print();
        winnerSearchAndPrint();
    }

    public void getUserCarNameByConsole() {
        String consoleInput = Console.readLine();
        car.insertUserName(consoleInput);
        car.checkUserNameError();
    }

    public void getUserRoundNumberByConsole() {
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
        }
    }

    public void winnerSearchAndPrint() {
        car.searchWinner();
    }

}
