package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Checker;
import racingcar.domain.NumberGenerator;
import racingcar.domain.UserInputManager;

public class Application {
    public static void main(String[] args) {
        List<String> names = UserInputManager.inputCarName();
        List<Car> cars = makeCars(names);

        int turn = UserInputManager.inputNumberOfAttempts();

        System.out.println("\n실행 결과");

        for (int i = 0; i < turn; i++) {
            playTurn(cars);
            printTurnInfo(cars);
        }

        List<Car> winners = Checker.checkWinners(cars);
        printWinners(winners);
    }

    public static List<Car> makeCars(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public static void playTurn(List<Car> cars) {
        List<Integer> randomNumbers = NumberGenerator.createRandomNumber(cars.size());
        int index = 0;
        for (Car car : cars) {
            int randomNumber = randomNumbers.get(index);
            if (Checker.checkAtLest4(randomNumber)) {
                car.goStraight();
            }
            index++;
        }
    }

    public static void printTurnInfo(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(makeCarInfo(car));
        }
        System.out.println();
    }

    public static String makeCarInfo(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");

        for (int i = 0; i < car.getStraightCount(); i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();

        String result = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}
