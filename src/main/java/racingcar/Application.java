package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }

    public static void playRound(final List<Car> cars, final int playTimes) {
        System.out.println("실행 결과");
        for (int i=0; i<playTimes; i++) {
            cars.forEach(car -> car
                    .move(generateRandomNumber()));
            printRoundResult(cars);
            System.out.println();
        }
        final List<Car> winners = judgeWinners(cars);
        printWinners(winners);
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static void printRoundResult(final List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + createHyphenResult(car)));
    }

    private static String createHyphenResult(final Car car) {
        final int position = car.getPosition();
        return "-".repeat(position);
    }

    private static List<Car> judgeWinners(final List<Car> cars) {
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

    private static void printWinners(final List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(winner -> winner.getName())
                .toList();
        String result = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + result);
    }
}
