package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceResult;

public class OutputView {

    public void printGameStartMessage() {
        System.out.print("\n실행 결과\n");
    }

    public void printRaceRoundResult(Cars cars) {
        for (Car car : cars.toList()) {
            System.out.printf("%s : %s\n", car.carName(), "-".repeat(car.distance()));
        }
        System.out.println();
    }

    public void printWinner(RaceResult raceResult) {
        List<String> winners = raceResult.getWinners();
        String winnerString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerString);
    }

}
