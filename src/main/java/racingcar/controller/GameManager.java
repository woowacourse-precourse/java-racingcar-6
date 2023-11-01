package racingcar.controller;

public class GameManager {

    public void startGame() {
        try {
            UserInputHandler inputHandler = new UserInputHandler();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
