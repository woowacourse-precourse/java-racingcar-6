package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.utility.RandomUtils;

import java.util.ArrayList;
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

    public static List<String> findWinner(Race race){
        List<Car> carRepository = race.getCarRepository();
        List<String> champions = new ArrayList<>();
        int maxAdvance = -1;
        for (Car car : carRepository) {
            if(car.getAdvanceNum() > maxAdvance){
                maxAdvance = car.getAdvanceNum();
            }
        }

        for (Car car : carRepository) {
            if(car.getAdvanceNum() == maxAdvance){
                champions.add(car.getName());
            }
        }
        return champions;
    }
}
