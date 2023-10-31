package racingcar;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInput userInput = new UserInput();
        String[] carNames = userInput.InputCar();
        int trying = userInput.InputNum();
        GameControl gameControl = new GameControl();
        gameControl.Controller(carNames,trying);
    }
}
