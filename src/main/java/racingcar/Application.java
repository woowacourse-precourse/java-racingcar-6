package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }

    public static int getMaxPosition(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public static void printWinners(final List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();
        String result = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + result);
    }
}
