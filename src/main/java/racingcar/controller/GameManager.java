package racingcar.controller;
import java.util.List;

public class GameManager {

    public void startGame() {
        try {
            UserInputHandler inputHandler = new UserInputHandler();
            List<String> nameList = inputHandler.getCarNameList();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
