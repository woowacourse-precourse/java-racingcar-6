package racingcar;

import racingcar.target.Computer;
import racingcar.target.Moderator;
import racingcar.target.User;

import java.util.ArrayList;
import java.util.List;

public class RacingcarGame {
    private final User user = new User();
    private final Computer computer = new Computer();
    private final Moderator moderator = new Moderator();

    private int position = 0;
    private String race = "";
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
        carName.forEach(i -> System.out.println(i.name + " : " + i.race));
        System.out.println();
    }

    public void setMovePoint() {
        List<Integer> computerNums = computer.getNumber(carName.size());
        for (int i = 0; i < carName.size(); i++) {
            if (computerNums.get(i) > 3) {
                carName.get(i).race += "-";
                carName.get(i).position += 1;
                continue;
            }
            carName.get(i).race += "";
        }
    }

    public void printResult() {

    }

}
