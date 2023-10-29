package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        play();
    }

    private static void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine();
        final List<String> members = Arrays.asList(carNames.split(","));
        final List<Car> cars = members.stream()
                .map(Car::new)
                .toList();

        System.out.println("시도할 회수는 몇회인가요?");
        final int playTimes = Integer.parseInt(Console.readLine());
        playRound(cars, playTimes);
        Console.close();
    }

    private static void playRound(final List<Car> cars, final int playTimes) {
        System.out.println("실행 결과");
        for (int i=0; i<playTimes; i++) {
            cars.forEach(car -> car
                    .move(generateRandomNumber()));
            printRoundResult(cars);
            System.out.println();
        }
        final List<Car> winners = judgeWinners(cars);
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static void printRoundResult(final List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + createHyphenResult(car)));
    }

    private static String createHyphenResult(final Car car) {
        final int position = car.getPostion();
        return "-".repeat(position);
    }

    private static List<Car> judgeWinners(final List<Car> cars) {
        final int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPostion() == maxPosition)
                .toList();
    }

    private static int getMaxPosition(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPostion)
                .max()
                .getAsInt();
    }
}
