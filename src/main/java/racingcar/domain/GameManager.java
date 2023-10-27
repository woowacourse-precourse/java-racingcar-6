package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final RoundManager roundManager = new RoundManager();

    private List<Car> cars = new ArrayList<>();

    private int attempts;

    public void initGame(){
        initRaceCars();
        initAttempts();
    }
    public void startGame(){
        for(int i=0;i<attempts;i++){
            playSingeRound();
        }
        List<String> winnerCarNames = Referee.determineWinner(this.cars);
        outputView.printWinners(winnerCarNames);
    }

    private void initRaceCars(){
        List<String> carNames = inputView.getCarNames();
        for(String carName: carNames){
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    private void initAttempts(){
        attempts = inputView.getAttempts();
    }

    private void playSingeRound(){
        roundManager.moveCarsInRound(cars);
        outputView.printRoundResult(cars);
    }
}
