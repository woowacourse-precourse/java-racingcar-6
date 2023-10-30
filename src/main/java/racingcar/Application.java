package racingcar;

import java.util.List;
import racingcar.domain.Player;
import racingcar.domain.RacingCar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCar racingCar = new RacingCar("pobi");
        racingCar.makeRandomNumber();
        racingCar.goOrStop();
        System.out.println(racingCar.randomNumber + " " + racingCar.distance);
        Player player = new Player();
        List<String> carNames = player.inputNames();
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i));
        }
        int numberOfRounds = player.inputNumberOfRounds();
    }
}
