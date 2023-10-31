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

    }

    public void getTryNumber() {

    }

    public void printMove() {

    }

    public void setMovePoint() {

    }

    public void printResult() {

    }

}
