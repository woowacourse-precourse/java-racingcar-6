package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.utils.Constant;
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
        if(setRandomNums() >= Constant.FORWARD){
            car.movingForward(Constant.INCREASE_DISTANCE);
        }
    }

    private Integer setRandomNums() {
        return Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
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
        int max = Constant.INITIAL_POSITION_VALUE;
        for (Car car : cars){
            if (max < car.getPosition()){
                max = car.getPosition();
            }
        }
        return max;
    }
}
