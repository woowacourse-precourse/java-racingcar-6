package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Constant;
import racingcar.model.RaceGame;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.UserOutput;

public class Service {
    public static void raceStart(RaceGame raceGame) {
        int execution_cnt = raceGame.getExecution_cnt();
        while(execution_cnt-- > 0){
            moveAllCars(raceGame.getParticipants());
            UserOutput.consoleOutExecutionResult(raceGame.getParticipants());
        }
        raceGame.setWinner(findWinner(raceGame.getParticipants()));
    }

    public static void moveAllCars(ArrayList<Car> cars){
        for(Car car :cars){
            if(canMove()){
                moveCar(car);
            }
        }
    }

    public static boolean canMove() {
        return Randoms.pickNumberInRange(Constant.BOUNDARY_START,Constant.BOUNDARY_END) > Constant.FORWARD_BOUNDARY;
    }

    public static void moveCar(Car car){
        car.moveForward();
    }

    public static ArrayList<Car> findWinner(ArrayList<Car> cars){
        return new ArrayList<Car>();
    }
}
