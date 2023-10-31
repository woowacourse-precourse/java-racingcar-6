package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> cars = generateCars();
        int roundCount = generateRoundCount();

        showProcessingBoard(cars, roundCount);
        showResultBoard(cars);
    }


    private static List<Car> generateCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine();
        validateCarNames(carNamesInput);
        String[] carNames = carNamesInput.split(",");

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
        return cars;
    }

    private static void validateCarNames(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    private static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private static int generateRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String roundCountInput = readLine();
        validateRoundCount(roundCountInput);
        return Integer.parseInt(roundCountInput);
    }

    private static void validateRoundCount(String roundCountInput) {
        for (int index = 0; index < roundCountInput.length(); index++) {
            validateRoundCountCharacter(roundCountInput.charAt(index));
        }
    }

    private static void validateRoundCountCharacter(char characterAtRoundCountInput) {
        if (!Character.isDigit(characterAtRoundCountInput)) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private static void showProcessingBoard(List<Car> cars, int roundCount) {
        System.out.println();
        System.out.println("실행 결과");

        for (int turn = 0; turn < roundCount; turn++) {
            moveCars(cars);
            printCars(cars);
        }
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    private static void showResultBoard(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        List<String> winnerNames = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

    private static int getMaxDistance(List<Car> cars) {
        return Objects.requireNonNull(cars.stream()
                        .max(Car::compareTo)
                        .orElse(null))
                .getDistance();
    }
}
