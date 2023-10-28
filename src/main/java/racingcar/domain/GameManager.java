package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RoundManager roundManager = new RoundManager();
    private final List<Car> cars;
    private final int attempts;

    public GameManager(){
        cars = initRaceCars();
        attempts = initAttempts();
    }

    public void run(){
        outputView.printGameStartMessage();
        for(int i=0;i<attempts;i++){
            playSingeRound();
        }
        List<String> winnerCarNames = Referee.determineWinner(this.cars);
        outputView.printWinners(winnerCarNames);
    }

    private List<Car> initRaceCars(){
        List<Car> cars = new ArrayList<>();
        List<String> carNames = inputView.getCarNames();
        for(String carName: carNames){
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private int initAttempts(){
        return inputView.getAttempts();
    }

    private void playSingeRound(){
        roundManager.moveCarsInRound(cars);
        outputView.printRoundResult(cars);
    }
}
