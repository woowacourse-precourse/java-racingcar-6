package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            racingCars.add(new RacingCar(carNames.get(i)));
        }

        return racingCars;
    }

    public void roundStart(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.makeRandomNumber();
            car.goOrStop();
        }
    }

    public void printRoundScore(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.printDistance();
        }
    }

    public void init() {
        Player player = new Player();
        List<RacingCar> cars = createRacingCars(player.inputNames());
        int numberOfRounds = player.inputNumberOfRounds();
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfRounds; i++) {
            roundStart(cars);
            printRoundScore(cars);
            System.out.println();
        }
    }
}
