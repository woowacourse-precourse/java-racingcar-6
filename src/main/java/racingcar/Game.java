package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.ViewOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private ViewOutput viewOutput = new ViewOutput();

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Car> playOneRound(List<Car> cars) {
        for(Car car : cars) {
            car.move(getRandomNumber());
        }
        return cars;
    }

    public List<Car> playAllRounds(List<Car> cars, int numberOfRounds) {
        System.out.println("실행 결과");
        for(int gameCount = 0; gameCount < numberOfRounds; gameCount++) {
            viewOutput.printRoundResult(playOneRound(cars));
        }
        System.out.println();
        return cars;
    }

    public List<Integer> makeLocationList(List<Car> cars) {
        List<Integer> carLocations = new ArrayList<>();

        for(Car car : cars) {
            carLocations.add(car.getCurrentLocation());
        }
        return carLocations;
    }

    public List<Car> findWinner(List<Car> cars) {
        List<Integer> carLocations = makeLocationList(cars);
        int maxLocation = Collections.max(carLocations);

        List<Car> winnerCars = new ArrayList<>();

        for(Car car: cars) {
            if(car.getCurrentLocation() == maxLocation)
                winnerCars.add(car);
        }

        return cars;
    }
}
