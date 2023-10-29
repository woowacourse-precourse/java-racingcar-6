package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static List<String> inputCarNameList() {
        String[] stringArray = Console.readLine().split(",");
        return List.of(stringArray);
    }

    public static List<Car> getCarsFromInput() {
        List<String> carNameList = inputCarNameList();
        boolean isLengthExceed = carNameList.stream().anyMatch(carName -> carName.length() > 5);
        if (isLengthExceed) {
            throw new IllegalArgumentException();
        }
        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int inputMoveCount() {
        String input = Console.readLine();
        int moveCount;
        try {
            moveCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (moveCount < 0) {
            throw new IllegalArgumentException();
        }
        return moveCount;
    }

    public static int pick1DigitRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void printPosition(Car car) {
        System.out.print(car.getName() + " : ");
        int position = car.getPosition();
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println();
    }

    public static List<Car> getWinners(List<Car> cars) {
        if (cars.isEmpty())
            throw new IllegalArgumentException();
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().getAsInt();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = getCarsFromInput();

        System.out.println("시도할 회수는 몇회인가요?");
        int moveCount = inputMoveCount();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            cars.forEach(Car::tryMoveForward);
            cars.forEach(Application::printPosition);
        }

        List<Car> winners = getWinners(cars);
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
