package racingcar.Controller;

import java.util.ArrayList;
import racingcar.Model.Car;
import racingcar.Model.UserInput;
import racingcar.Model.WinnerSelector;
import racingcar.Utils.Random;
import racingcar.View.GameProcessView;
import racingcar.View.GameResultView;


public class GameController {

    // TODO: 변수명 정리, 멤버 변수들 정리, 우승자 계산 및 출력 구현

    private final int MOVE_THRESHOLD = 4;

    private ArrayList<Car> carList = new ArrayList<Car>();
    private UserInput userInput;

    GameProcessView gameProcessView = new GameProcessView();
    GameResultView gameResultView = new GameResultView();
    WinnerSelector winnerSelector = new WinnerSelector();

    Random random = new Random();

    public void gameProcess() {
        initGame();
        registerPlayers();

        gameProcessView.printResultNoticeMsg();
        for (int i = 0; i < userInput.turnNumInteger; i++) {
            playOneTurn();
            System.out.print(gameProcessView.EMPTY_SPACE);
        }

        ArrayList<String> winnerList = winnerSelector.select(carList);
        gameResultView.printWinner(winnerList);
    }

    public void initGame() {
        this.userInput = new UserInput();
    }

    public void registerPlayers() {
        for (String carName : userInput.carNameList) {
            Car carGamePlayer = new Car(carName);
            carList.add(carGamePlayer);
        }
    }


    public void moveByDiceRoll(Car carGamePlayer) {
        if (random.diceZeroToNine() >= MOVE_THRESHOLD) {
            carGamePlayer.MoveOneStepForward();
        }
    }

    public void playOneTurn() {
        for (Car carGamePlayer : carList) {
            moveByDiceRoll(carGamePlayer);
            gameProcessView.printCarLocation(carGamePlayer.getCarName(), carGamePlayer.getLocation());
        }
    }


}
