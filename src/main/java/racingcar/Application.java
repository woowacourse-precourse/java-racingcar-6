package racingcar;

public class Application {
    public static void main(String[] args) {

        InputController inputController = new InputController();
        inputController.inputCarName();
        inputController.inputCycleNum();
        PrintController printController = new PrintController();
        printController.printDirection();
        FindWinnerController findWinnercontroller = new FindWinnerController();
        findWinnercontroller.totalCycle();
        findWinnercontroller.findWinner();
        printController.printWinner();
    }
}