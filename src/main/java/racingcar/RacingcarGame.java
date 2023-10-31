package racingcar;

import racingcar.target.Computer;
import racingcar.target.Moderator;
import racingcar.target.User;

import java.util.ArrayList;

public class RacingcarGame {
    private final User user = new User();
    private final Computer computer = new Computer();
    private final Moderator moderator = new Moderator();

    private String name;
    private int tryNumber;
    private final ArrayList<RacingcarGame> carName = new ArrayList<>();

    RacingcarGame() {
    }

    RacingcarGame(String name) {
        this.name = name;
    }

    public void gameStart() {
        makeCarNameList();
        getTryNumber();
        for (int i = 0; i < tryNumber; i++) {
            setMovePoint();
            printMove();
        }
        printResult();
    }

    public void makeCarNameList() {
        moderator.printNameInputMsg();
        String userNameInput = user.getUserInput();
        String[] splitStr = userNameInput.split(",");
        for (int i = 0; i < splitStr.length; i++) {
            moderator.validateCarName(splitStr[i]);
            carName.add(new RacingcarGame(splitStr[i]));
        }
    }

    public void getTryNumber() {
        moderator.printTryInputMsg();
        tryNumber = Integer.parseInt(user.getUserInput());
    }

    public void printMove() {

    }

    public void setMovePoint() {

    }

    public void printResult() {

    }

}
