package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private final Referee referee;
    private final int round;

    public RacingGame(List<Car> carList, Referee referee, int round) {
        this.cars = carList;
        this.referee = referee;
        this.round = round;
    }

    public void processRound() {
        for (int i = 0; i < this.round; i++) {
            this.cars.stream().forEach(Car::processTurn);
        }
        System.out.println();
    }

    public void printWinners() {
        String prefixComment = "최종 우승자 : ";
        List<String> winnerNames = this.referee.getFurthestCarNames(this.cars);
        System.out.printf("%s%s%n", prefixComment, String.join(",", winnerNames));
    }
}
