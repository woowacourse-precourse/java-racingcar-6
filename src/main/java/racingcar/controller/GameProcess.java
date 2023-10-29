package racingcar.controller;
import racingcar.controller.GameUtils;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

public class GameProcess {
    public void processGame(RacingCarList racingCars){
        for(int carIndex = 0; carIndex < racingCars.size(); carIndex++){
            int randomNumber = new GameUtils().makeRandomNumber();
            RacingCar currentCar = racingCars.get(carIndex);
            currentCar.moveForward(randomNumber);
        }
    }

}
