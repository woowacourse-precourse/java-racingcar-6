package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;

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
}
