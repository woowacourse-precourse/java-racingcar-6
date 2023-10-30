package racingcar.Controller;

import java.util.ArrayList;
import racingcar.Model.Car;
import racingcar.Model.UserInput;
import racingcar.Utils.Random;
import racingcar.View.GameView;

public class GameController {

    // TODO: 변수명 정리, 멤버 변수들 정리, 우승자 계산 및 출력 구현

    private final int MOVE_THRESHOLD = 4;

    private ArrayList<Car> carList = new ArrayList<Car>();
    private UserInput userInput;
    Random random = new Random();
    GameView gameView = new GameView();

    public void gameProcess() {
        initGame();
        registerPlayers();

        gameView.printResultNoticeMsg();
        for (int i = 0; i < userInput.turnNumInteger; i++) {
            playOneTurn();
        }
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
            gameView.printCarLocation(carGamePlayer.getCarName(), carGamePlayer.getLocation());
        }
        System.out.println("\n");
    }


}
