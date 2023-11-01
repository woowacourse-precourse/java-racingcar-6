package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.utility.RandomUtils;

import java.util.List;

public class RaceService {

    public static int remainRound;

    public RaceService(int raceRound) {
        remainRound = raceRound;
    }

    public void moveCarByLogic(Race race){
        List<Car> carRepository = race.getCarRepository();
        for (Car car : carRepository) {
            int randomNum = RandomUtils.generateRandomValue();
            if(randomNum >= 4){
                car.increaseAdvanceNum();
            }
        }
        remainRound--;
    }
}
