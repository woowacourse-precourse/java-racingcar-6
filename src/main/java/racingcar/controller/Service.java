package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Constant;
import racingcar.model.RaceGame;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.UserOutput;

import static java.lang.Math.max;

public class Service {
    public static void raceStart(RaceGame raceGame) {
        int execution_cnt = raceGame.getExecution_cnt();
        while(execution_cnt-- > 0){
            moveAllCars(raceGame.getParticipants());
            UserOutput.consoleOutExecutionResult(raceGame.getParticipants());
        }
        raceGame.setWinner(findWinner(raceGame.getParticipants()));
    }

    public static void moveAllCars(ArrayList<Car> cars) {
        for(Car car : cars){
            if(canMove()){
                moveCar(car);
            }
        }
    }

    public static boolean canMove() {
        return Randoms.pickNumberInRange(Constant.BOUNDARY_START, Constant.BOUNDARY_END) >= Constant.FORWARD_BOUNDARY;
    }

    public static void moveCar(Car car) {
        car.moveForward();
    }

    public static ArrayList<Car> findWinner(ArrayList<Car> cars) {
        ArrayList<Car> winners = new ArrayList<>();
        int max_distance = findMaxDistance(cars);

        for(Car car : cars){
            if(car.getLocation() == max_distance){
                winners.add(car);
            }
        }

        return winners;
    }

    public static Integer findMaxDistance(ArrayList<Car> cars) {
        int max_distance = 0;
        for(Car car : cars){
            max_distance = max(car.getLocation(), max_distance);
        }

        return max_distance;
    }
}
