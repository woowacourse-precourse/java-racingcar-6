package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void printRoundResult(final List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + createHyphenResult(car)));
    }

    private static String createHyphenResult(final Car car) {
        final int position = car.getPosition();
        return "-".repeat(position);
    }

    public static List<Car> judgeWinners(final List<Car> cars) {
        final int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private static int getMaxPosition(final List<Car> cars) {
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
