package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.repository.CarManager;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int MOVE_FORWARD_STEP = 1;
    private static final int LIMIT_MOVE_MIN = 4;
    private int maxDistance = 0;
    private final CarManager carManager;
    private final Round round;

    public Game(CarManager carManager, Round round) {
        this.carManager = carManager;
        this.round = round;
    }

    public void start(){
        while (round.isGameInProgress()){
            playRound();
            System.out.println();
            round.riseRound();
        }
        printGameWinners();
    }

    private void printGameWinners(){
        OutputView.printGameWinners(getWinners());
    }
    private List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        for (Car car : carManager.getCars()) {
            updateWinners(car, winners);
        }
        return winners;
    }
    private void updateWinners(Car car, List<String> winners) {
        if (car.getPosition() > maxDistance) {
            winners.clear();
            maxDistance = car.getPosition();
            winners.add(car.getCarName());
        } else if (car.getPosition() == maxDistance) {
            winners.add(car.getCarName());
        }
    }
    private void printRoundProcess(String car, int position){
        OutputView.printGameResult(car, position);
    }
    private void playRound(){
        for (Car car : carManager.getCars()) {
            moveCar(car);
            printRoundProcess(car.getCarName(), car.getPosition());
        }
    }
    private void moveCar(Car car){
        if(getRandomNumber() >= LIMIT_MOVE_MIN){
            car.increasePosition(MOVE_FORWARD_STEP);
        }
    }
    private int getRandomNumber(){
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
