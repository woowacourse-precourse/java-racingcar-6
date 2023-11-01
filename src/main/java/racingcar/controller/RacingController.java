package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Game;


import java.util.ArrayList;
import java.util.List;

public class RacingController {
    public void play(Game game){
        moveForward(game);
        game.increaseTriedNum();
    }

    public List<String> getWinner(Game game){
        List<Car> cars = game.getCars();
        int maxPosition = getMaxPosition(cars);
        return getMaxPositionCars(cars,maxPosition);
    }

    private void moveForward(Game game){
        for (Car car : game.getCars()) {
            validMovement(car);
        }
    }

    private void validMovement(Car car){
        if(setRandomNums() >= 4){
            car.movingForward(1);
        }
    }

    private Integer setRandomNums() {
        return Randoms.pickNumberInRange(0,9);
    }

    private List<String> getMaxPositionCars (List<Car> cars, int maxPosition) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars){
            if(car.getPosition() == maxPosition){
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    private int getMaxPosition(List<Car> cars){
        int max = 0;
        for (Car car : cars){
            if (max < car.getPosition()){
                max = car.getPosition();
            }
        }
        return max;
    }
}
