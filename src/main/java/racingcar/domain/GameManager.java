package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

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
        System.out.println("\n"+EXECUTION_RESULT_MESSAGE);
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
