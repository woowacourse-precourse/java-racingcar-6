package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class RacingController {
    int rounds;
    List<Car> racingCars;

    protected RacingController(int rounds, List<Car> racingCars) {
        this.rounds = rounds;
        this.racingCars = racingCars;
        this.proceedRound();
    }

    private void proceedRound() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < this.rounds; i++) {
            randomlyGoForward(this.racingCars);
            printRoundResult();
        }
        endRacing();
    }

    private void printRoundResult() {
        for (Car car : this.racingCars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    private void endRacing() {
        List<Car> winnerCars = new ArrayList<>();
        List<String> winnerRacers = new ArrayList<>();
        Car maxRacingProgressCar;

        do {
            maxRacingProgressCar = Collections.max(this.racingCars);
            winnerCars.add(maxRacingProgressCar);
            racingCars.remove(Collections.max(this.racingCars));
        } while (!this.racingCars.isEmpty()
                && Collections.max(this.racingCars).compareTo(maxRacingProgressCar)==0);
        for (Car car : winnerCars){
            winnerRacers.add(car.getRacerName());
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winnerRacers));
    }

    private void randomlyGoForward(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) car.incrementRacingProgress();
        }
    }
}
