package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Player player = new Player();
    private final Referee referee = new Referee();
    private List<String> carNames = new ArrayList<>();
    private List<Car> racingCars = new ArrayList<>();
    private int count;

    public void play() {

        carNames = player.validateInputCarNames(player.inputNames());
        count = player.validateInputCounts(player.inputCounts());

        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }

        System.out.println();
        System.out.println("실행결과");

        for (int i = 0; i < count; i++) {
            for (Car car : racingCars) {
                car.decideGo(car.makeRandomNum());
                car.printResult();
            }
            System.out.println();
        }

        List<String> winnerCarNames = referee.findWinner(racingCars);
        referee.printWinner(winnerCarNames);

    }

}
