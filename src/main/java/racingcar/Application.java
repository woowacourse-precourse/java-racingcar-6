package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = parseCarNames();
        List<RacingCar> cars = createCars(carNames);

        int tryCount = parseTryCount();
        for (int count = 0; count < tryCount; count++) {
            for (RacingCar car : cars) {
                car.moveForward(pickRandom());
                System.out.println(car.getDescription());
            }
            System.out.println();
        }

        System.out.println("최종 우승자 : " + getWinnerNames(cars));
    }

    private static List<String> parseCarNames() {
        return Arrays.stream(readLine().split(",")).toList();
    }

    private static List<RacingCar> createCars(List<String> carNames) {
        return carNames.stream().map(RacingCar::new).toList();
    }

    private static int parseTryCount() {
        String inputString = readLine();
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input string " + inputString + " is not a number.");
        }
    }

    private static int pickRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static String getWinnerNames(List<RacingCar> cars) {
        int maxPosition = getMaxPosition(cars);
        List<RacingCar> winners = findWinner(cars, maxPosition);
        return collectWinnerNames(winners);
    }

    private static Integer getMaxPosition(List<RacingCar> cars) {
        return Collections.max(cars.stream().map(RacingCar::getPosition).toList());
    }

    private static List<RacingCar> findWinner(List<RacingCar> cars, int maxPosition) {
        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
    }

    private static String collectWinnerNames(List<RacingCar> winners) {
        return winners.stream().map(RacingCar::getName).collect(Collectors.joining(", "));
    }
}
