package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.controller.Controller;
import racingcar.domain.Round;
import racingcar.repository.CarAdmin;
import racingcar.view.outputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int LIMIT_MOVE_MIN = 4;
    private int maxDistance = 0;
    private final CarAdmin carAdmin;
    private final Round round;

    public Game(CarAdmin carAdmin, Round round) {
        this.carAdmin = carAdmin;
        this.round = round;
    }

    public void roundProcess(){
        while (round.checkGameEndState()){
            movePosition();
            System.out.println();
            round.riseRound();
        }
        printGameWinners();
    }

    private void printGameWinners(){
        outputView.printGameWinners(getWinners());
    }
    private List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        for (Car car : carAdmin.getCars()) {
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
    private void printRoundProcess(String car, int pos){
        outputView.printGameResult(car, pos);
    }
    private void movePosition(){
        for (Car car : carAdmin.getCars()) {
            checkLimitMin(car);
            printRoundProcess(car.getCarName(), car.getPosition());
        }
    }
    private void checkLimitMin(Car car){
        if(getRandomNumber() >= LIMIT_MOVE_MIN){
            car.addDistance(1);
        }
    }
    private int getRandomNumber(){
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
