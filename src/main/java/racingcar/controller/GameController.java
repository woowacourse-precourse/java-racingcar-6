package racingcar.controller;
import racingcar.view.InputView;
public class GameController {
    private final InputView inputView;

    public GameController() {
        this.inputView = new InputView();
    }

    public void runGame(){
        initGame();
    }


    public void initGame(){
        String userCarNames = inputView.inputCarNames();
        String raceTimes = inputView.inputRaceTimes();
    }
}