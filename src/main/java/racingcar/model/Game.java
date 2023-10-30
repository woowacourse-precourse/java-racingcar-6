package racingcar.model;


import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Game implements Rule {

    List<Car> cars;

    public Game() {
        List<String> carNames = getCarNames();
        cars = new ArrayList<Car>();
        for (String carName : carNames) {
            cars.add(new RacingCar(carName));
        }
    }

    @Override
    public List<String> getCarNames() {
        return List.of(readLine().split(","));
    }

    @Override
    public Integer getNumberOfRounds() throws IllegalArgumentException {
        int res = Integer.parseInt(readLine());
        if (res < 0) {
            throw new IllegalArgumentException();
        }
        return res;
    }

    @Override
    public void printCurrentPerformance() {

    }

    @Override
    public void printBestPerformers() {

    }
}
