package racingcar;

import java.util.List;
import racingcar.domain.Player;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarGame racingCarGame = new RacingCarGame();
        RacingCar racingCar = new RacingCar("pobi");
        racingCar.makeRandomNumber();
        racingCar.goOrStop();
        System.out.println(racingCar.randomNumber + " " + racingCar.distance);
        Player player = new Player();
        List<String> carNames = player.inputNames();
        List<RacingCar> cars = racingCarGame.createRacingCars(carNames);
        for (RacingCar car : cars) {
            System.out.println(car.toString());
        }
        int numberOfRounds = player.inputNumberOfRounds();
    }
}
